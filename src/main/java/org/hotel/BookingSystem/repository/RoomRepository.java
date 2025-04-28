package org.hotel.BookingSystem.repository;

import org.hotel.BookingSystem.model.Room;
import org.hotel.BookingSystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByHotelId(Long hotelId);
}

