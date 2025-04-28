package org.hotel.BookingSystem.repository;

import org.hotel.BookingSystem.Bean.BeanHotelFilter;
import org.hotel.BookingSystem.enums.RoomType;
import org.hotel.BookingSystem.model.Hotel;
import org.hotel.BookingSystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface HotelRepository extends JpaRepository<Hotel, Long> {
   List <Hotel> findById(Integer id);


    @Query("SELECT h   FROM Hotel h LEFT JOIN Room r ON h.id = r.hotelId "  +
            "WHERE h.city = :city OR " +
            "(h.name LIKE %:searching% OR  " +
    "(r.price BETWEEN :minPrice AND :maxPrice) OR "  +
    " r.roomType = :roomType)")
    List<Hotel> findHotelsByfilter(@Param("city") String city,
                                   @Param("minPrice")Double minPrice,
                                   @Param("maxPrice")Double maxPrice,
                                   @Param("roomType")RoomType roomType,
                                   @Param("searching") String searching);



}
