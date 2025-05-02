package org.hotel.BookingSystem.Bean;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Setter
@Getter
public class BeanHotelDetails {
    private String name;
    private String address;
    private String city;
    private String contact;

    private List<BeanRoomDetails> beanRoomDetailroomList;



}
