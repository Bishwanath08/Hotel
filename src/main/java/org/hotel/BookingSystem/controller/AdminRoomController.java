package org.hotel.BookingSystem.controller;

import org.hotel.BookingSystem.model.Room;
import org.hotel.BookingSystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/rooms")
public class AdminRoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/add/{hotelId}")
    public ResponseEntity<?> addRoom(@PathVariable Long hotelId, @RequestBody Room room) {
        try {
            Room created = roomService.addRoom(hotelId, room);
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Room>> getRoom(@PathVariable Long hotelId) {
        return ResponseEntity.ok(roomService.getRoomsByHotel(hotelId));
    }

    @PutMapping("/update/{roomId}")
    public ResponseEntity<?> updateRoom(@PathVariable Long roomId, @RequestBody Room room) {
        try {
            Room updated = roomService.updateRoom(roomId, room);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{roomId}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long roomId) {
        try {
            roomService.deleteRoom(roomId);
            return ResponseEntity.ok(roomId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
