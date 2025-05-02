package org.hotel.BookingSystem.controller;

import org.hotel.BookingSystem.DTOs.BookingConfirmation;
import org.hotel.BookingSystem.DTOs.BookingRequest;
import org.hotel.BookingSystem.Exception.ResourceNotFoundException;
import org.hotel.BookingSystem.model.Booking;
import org.hotel.BookingSystem.model.User;
import org.hotel.BookingSystem.service.BookingService;
import org.hotel.BookingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @PostMapping("/admin")
    public ResponseEntity<?> createBooking(@RequestHeader("Authorization") String authHeader, @RequestBody Booking booking) {
        try {
            String token = authHeader.substring(7);
            userService.validateAdmin(token);

            Booking savedBooking = bookingService.createBooking(booking);
            return ResponseEntity.ok(savedBooking);
        } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> bookRoom(@RequestBody BookingRequest request)  {
        try{
            BookingConfirmation confirmation = bookingService.bookRoom(request);
            return ResponseEntity.ok(confirmation);
        } catch (ResourceNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/customer-book")
    public ResponseEntity<?> customerBookRoom (@RequestHeader("Authorization") String authHeader, @RequestBody BookingRequest request) {
        try {
            String token = authHeader.substring(7);
            User customer = userService.getUserByToken(token);

            if (!"CUSTOMER" .equalsIgnoreCase(customer.getUserType().toString())){
                throw  new RuntimeException("Access denied: not a customer");
            }

           request.setUserId(customer.getId());

           BookingConfirmation confirmation = bookingService.bookRoom(request);
            return  ResponseEntity.ok(confirmation);

        } catch (ResourceNotFoundException e) {
          return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PostMapping("/booking")
    public ResponseEntity<Object> customerBookRoom(@RequestBody BookingRequest request) {
        try {
            BookingConfirmation confirmation = bookingService.bookRoom(request);
            return ResponseEntity.ok(confirmation);
        } catch (ResourceNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
