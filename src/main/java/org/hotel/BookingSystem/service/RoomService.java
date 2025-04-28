package org.hotel.BookingSystem.service;

import org.hotel.BookingSystem.model.Hotel;
import org.hotel.BookingSystem.model.Room;
import org.hotel.BookingSystem.repository.HotelRepository;
import org.hotel.BookingSystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public Room addRoom(Long hotelId, Room room) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found!"));

        room.setHotelId(hotel.getId());
        return roomRepository.save(room);
    }

    public List<Room> getRoomsByHotel(Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    public Room updateRoom(Long roomId, Room updatedRoom) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found! "));

        room.setRoomNumber(updatedRoom.getRoomNumber());
        room.setPrice(updatedRoom.getPrice());
        room.setAvailable(updatedRoom.isAvailable());
        room.setRoomType(updatedRoom.getRoomType());

        return roomRepository.save(room);
    }

    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }


    public List<Room> getAllocatedRoom() {
        List<Room> allRooms = roomRepository.findAll();
        return allRooms.stream().filter(room -> !room.isAvailable()).collect(Collectors.toList());
    }

}
