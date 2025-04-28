package org.hotel.BookingSystem.controller;

import org.hotel.BookingSystem.Bean.BeanLogin;
import org.hotel.BookingSystem.Bean.BeanRegister;
import org.hotel.BookingSystem.DTOs.LoginResponseBean;
import org.hotel.BookingSystem.DTOs.RegisterResponseBean;
import org.hotel.BookingSystem.DTOs.TokenResponseBean;
import org.hotel.BookingSystem.model.User;
import org.hotel.BookingSystem.repository.UserRepository;
import org.hotel.BookingSystem.service.HotelService;
import org.hotel.BookingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private HotelService hotelService;



    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody BeanRegister register) {

        try {
            User registered = userService.registerCustomer(register);
            RegisterResponseBean response = new RegisterResponseBean(
                    "Registered Successfully",
                    registered.getId(),
                    registered.getName(),
                    registered.getEmail());
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.getStackTrace();
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
//            System.out.println(e.getMessage());
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody BeanLogin loginReq) {
        try{
            User logined = userService.loginCustomer(loginReq);
            LoginResponseBean responseBean = new LoginResponseBean(
                    "Login Successfully", logined.getName(), logined.getToken());
//            return   ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            return   ResponseEntity.ok(responseBean);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials!");
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<?> profileDetails(@RequestHeader("Authorization") String authHeader) {
        try{
            String token = authHeader.replace("Bearer ", "").trim();

            User userByToken = userService.getUserByToken(token);
            TokenResponseBean tokenResponseBean = new TokenResponseBean(
                    "full detail of User! ", userByToken.getName(), userByToken.getEmail(), userByToken.getPhone()
            );
            return ResponseEntity.ok(tokenResponseBean);
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }
}
