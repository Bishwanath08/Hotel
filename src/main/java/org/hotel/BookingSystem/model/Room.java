package org.hotel.BookingSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hotel.BookingSystem.enums.RoomType;

import java.util.List;


@Entity
@Table(name = "room")
@Getter
@Setter

public class Room {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

   private double price;
   private boolean available;

   @Column(name = "fk_hotel_Id")
   private Long hotelId;



}
