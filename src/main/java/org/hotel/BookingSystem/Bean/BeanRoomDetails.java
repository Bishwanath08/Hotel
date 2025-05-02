package org.hotel.BookingSystem.Bean;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hotel.BookingSystem.enums.RoomType;
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class BeanRoomDetails {

    private RoomType roomType;
    private double price;
    private boolean available;


}
