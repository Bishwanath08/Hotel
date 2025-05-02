package org.hotel.BookingSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "booking")
@Setter
@Getter
public class Booking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_number")
    private Long bookingNumber;

    private Long userId;
    private Long hotelId;

    private Long roomId;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalAmount;

   


}
