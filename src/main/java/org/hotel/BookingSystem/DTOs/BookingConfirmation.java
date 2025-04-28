package org.hotel.BookingSystem.DTOs;

public class BookingConfirmation {
    private Long bookingNumber;
    private String roomNumber;
    private double totalAmount;

    public BookingConfirmation(Long bookingNumber, String roomNumber, double totalAmount) {
        this.bookingNumber = bookingNumber;
        this.roomNumber = roomNumber;
        this.totalAmount = totalAmount;
    }

    public Long getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(Long bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
