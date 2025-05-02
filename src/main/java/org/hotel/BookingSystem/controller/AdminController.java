package org.hotel.BookingSystem.controller;

import org.hotel.BookingSystem.Bean.BeanLogin;
import org.hotel.BookingSystem.Bean.BeanRegister;
import org.hotel.BookingSystem.DTOs.LoginResponseBean;
import org.hotel.BookingSystem.DTOs.RegisterResponseBean;
import org.hotel.BookingSystem.DTOs.TokenResponseBean;
import org.hotel.BookingSystem.model.Hotel;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private HotelService hotelService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody BeanRegister register) {

        try {
            User registered = userService.registerAdmin(register);
            RegisterResponseBean responseBean = new RegisterResponseBean(
                    "Registered Successfully",
                    registered.getId(),
                    registered.getName(),
                    registered.getEmail());
            return ResponseEntity.ok(responseBean);

        } catch (Exception e) {
            e.getStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody BeanLogin loginReq) {
        try {
            User logined = userService.loginAdmin(loginReq);
            LoginResponseBean responseBean = new LoginResponseBean(
                    "Login Successfully", logined.getName(), logined.getToken());
            return   ResponseEntity.ok(responseBean);
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials!");
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<?> profileDetails(@RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.replace("Bearer", "").trim();

            User userByToken = userService.getAdminByToken(token);
            TokenResponseBean tokenResponseBean = new TokenResponseBean(
                    "Full Detail of Admin!", userByToken.getName(), userByToken.getEmail(), userByToken.getPhone()
            );
            return  ResponseEntity.ok(tokenResponseBean);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

   @PostMapping("/hotel")
    public ResponseEntity<?> addHotel(@RequestHeader ("Authorization") String token, @RequestBody Hotel hotel) {
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7); // Remove 'Bearer ' (7 characters)
            } else {
                throw new Exception("Invalid Authorization header format");
            }
            userService.validateAdmin(token);
            Hotel saved = hotelService.addHotel(hotel);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
   }


   @PutMapping("/hotel/{id}")
   public ResponseEntity<?> updateHotel(@RequestHeader("Authorization") String token,
                                        @PathVariable Long id,
                                        @RequestBody Hotel hotel) {
        try {
            userService.validateAdmin(token);
            Hotel updated = hotelService.updateHotel(id, hotel);
            return  ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
   }

  @DeleteMapping("/hotel/{id}")
    public ResponseEntity<?> deleteHotel(@RequestHeader("Authorization") String token,
                                         @PathVariable Long id)  {
        try {
            userService.validateAdmin(token);
            hotelService.deleteHotel(id);
            return ResponseEntity.ok("Hotel deleted successfully.");
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}




