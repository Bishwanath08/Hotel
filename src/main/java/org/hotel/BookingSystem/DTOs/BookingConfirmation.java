package org.hotel.BookingSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hotel.BookingSystem.enums.RoomType;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingConfirmation {
    private Long bookingNumber;
    private String roomNumber;
    private String name;
    private String address;
    private String contact;
    private RoomType roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalAmount;




}
