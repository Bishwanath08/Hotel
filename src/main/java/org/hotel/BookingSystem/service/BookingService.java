package org.hotel.BookingSystem.service;

import org.hotel.BookingSystem.DTOs.BookingConfirmation;
import org.hotel.BookingSystem.DTOs.BookingRequest;
import org.hotel.BookingSystem.Exception.ResourceNotFoundException;
import org.hotel.BookingSystem.model.Booking;
import org.hotel.BookingSystem.model.Room;
import org.hotel.BookingSystem.repository.BookingRepository;
import org.hotel.BookingSystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
public class BookingService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking){
        booking.setBookingNumber(generateBookingNumber());
        return bookingRepository.save(booking);
    }

    public Long generateBookingNumber() {
        return System.currentTimeMillis();
    }

    public BookingConfirmation bookRoom(BookingRequest request) throws ResourceNotFoundException {
        Room room  = roomRepository.findById(request.getRoomId()).orElseThrow(()
        -> new RuntimeException("Room not Found"));

        if (!room.isAvailable()) {
            throw new ResourceNotFoundException("Room is already booked. Please select another room.");
        }


        long days = ChronoUnit.DAYS.between(request.getCheckInDate(), request.getCheckOutDate());
        double total = days * room.getPrice();

        Booking booking = new Booking();
        booking.setBookingNumber(System.currentTimeMillis());
        booking.setUserId(request.getUserId());
        booking.setHotelId(request.getHotelId());
        booking.setRoomId(room.getId());
        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());
        booking.setTotalAmount(total);

        room.setAvailable(true);
        roomRepository.save(room);
        bookingRepository.save(booking);

        return new BookingConfirmation(booking.getBookingNumber(), room.getRoomNumber(), total);

    }

}
