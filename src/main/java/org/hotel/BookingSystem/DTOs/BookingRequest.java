package org.hotel.BookingSystem.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.hotel.BookingSystem.enums.RoomType;

import java.time.LocalDate;
@Getter
@Setter
public class BookingRequest {
    private Long userId;
    private Long hotelId;
    private RoomType roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

}
