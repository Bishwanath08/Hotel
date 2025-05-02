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
public class BeanHotelFilter {
    private  String searching ;
    private String city;
    private Double minPrice;
    private Double maxPrice;
    private RoomType roomType;


}
