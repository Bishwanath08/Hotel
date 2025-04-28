package org.hotel.BookingSystem.controller;

import org.hotel.BookingSystem.Bean.BeanHotelDetails;
import org.hotel.BookingSystem.Bean.BeanHotelFilter;
import org.hotel.BookingSystem.Exception.ResourceNotFoundException;
import org.hotel.BookingSystem.model.Hotel;
import org.hotel.BookingSystem.repository.HotelRepository;
import org.hotel.BookingSystem.repository.RoomRepository;
import org.hotel.BookingSystem.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping("/filter")
    public ResponseEntity<List<Hotel>> filterHotel(@RequestBody BeanHotelFilter filter) {
        List<Hotel> hotels = hotelService.getFilteredHotels(filter);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Object> getHotelDetails(@PathVariable Long hotelId)  {
        BeanHotelDetails beanHotelDetails;
       try {
            beanHotelDetails = hotelService.getHotelDetails(hotelId) ;
       } catch (ResourceNotFoundException e) {
           return ResponseEntity.ok(e.getMessage());
       }
        return ResponseEntity.ok(beanHotelDetails);
    }

}
