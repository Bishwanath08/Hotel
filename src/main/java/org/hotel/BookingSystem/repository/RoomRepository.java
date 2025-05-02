package org.hotel.BookingSystem.repository;

import org.hibernate.annotations.processing.SQL;
import org.hotel.BookingSystem.enums.RoomType;
import org.hotel.BookingSystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByHotelId(Long hotelId);

    @Query("SELECT r FROM Room r " +
            "LEFT JOIN Booking b ON r.id = b.roomId " +
            "AND b.checkInDate < :checkInDate " +
            "AND b.checkInDate > :checkInDate " +
            "WHERE r.hotelId = :hotelId " +
            "AND r.roomType = :roomType " +
            "AND r.available = true " +
            "AND b.id IS NULL")
    List<Room> findFirstAvailableRoom(
            @Param("hotelId") Long hotelId,
            @Param("roomType") RoomType roomType,
            @Param("checkInDate") LocalDate checkInDate,
            @Param("checkOutDate") LocalDate checkOutDate
    );

}

