package org.hotel.BookingSystem.DTOs;

import org.hotel.BookingSystem.enums.RoomType;

import java.time.LocalDate;

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

    public BookingConfirmation(Long bookingNumber, String roomNumber, String name, String address, String contact, RoomType roomType, LocalDate checkInDate, LocalDate checkOutDate, double totalAmount) {
        this.bookingNumber = bookingNumber;
        this.roomNumber = roomNumber;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;
    }

    public BookingConfirmation() {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
