package org.hotel.BookingSystem.Bean;

import org.hotel.BookingSystem.enums.RoomType;


public class BeanHotelFilter {
    private  String searching ;
    private String city;
    private Double minPrice;
    private Double maxPrice;
    private RoomType roomType;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getSearching() {
        return searching;
    }

    public void setSearching(String searching) {
        this.searching = searching;
    }
}
