package org.hotel.BookingSystem.Bean;


import org.hotel.BookingSystem.enums.RoomType;

public class BeanRoomDetails {

    private RoomType roomType;

    private double price;
    private boolean available;

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
