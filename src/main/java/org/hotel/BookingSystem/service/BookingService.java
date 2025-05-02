package org.hotel.BookingSystem.service;

import org.hotel.BookingSystem.DTOs.BookingConfirmation;
import org.hotel.BookingSystem.DTOs.BookingRequest;
import org.hotel.BookingSystem.Exception.ResourceNotFoundException;
import org.hotel.BookingSystem.enums.RoomType;
import org.hotel.BookingSystem.model.Booking;
import org.hotel.BookingSystem.model.Hotel;
import org.hotel.BookingSystem.model.Room;
import org.hotel.BookingSystem.repository.BookingRepository;
import org.hotel.BookingSystem.repository.HotelRepository;
import org.hotel.BookingSystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public Booking createBooking(Booking booking){
        booking.setBookingNumber(generateBookingNumber());
        return bookingRepository.save(booking);
    }

    public Long generateBookingNumber() {
        return System.currentTimeMillis();
    }




    public BookingConfirmation bookRoom(BookingRequest request) throws ResourceNotFoundException {

        // 1. Fetch available room
        List<Room> roomList = roomRepository.findFirstAvailableRoom(
                request.getHotelId(),
                request.getRoomType(),
                request.getCheckInDate(),
                request.getCheckOutDate()
        );

        if (roomList.isEmpty()) {
            throw new ResourceNotFoundException("No available room found for the selected type and dates.");
        }

        Room roomToBook = roomList.get(0);

        // 2. Fetch hotel information
        Hotel hotel = hotelRepository.findById(request.getHotelId())
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));

        // 3. Calculate total amount
        long days = ChronoUnit.DAYS.between(request.getCheckInDate(), request.getCheckOutDate());
        double total = days * roomToBook.getPrice();

        // 4. Create booking
        Booking booking = new Booking();
        booking.setBookingNumber(System.currentTimeMillis());
        booking.setUserId(request.getUserId());
        booking.setHotelId(hotel.getId());
        booking.setRoomId(roomToBook.getId());
        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());
        booking.setTotalAmount(total);

        bookingRepository.save(booking);

        BookingConfirmation confirmation = new BookingConfirmation();
        confirmation.setBookingNumber(booking.getBookingNumber());
        confirmation.setName(hotel.getName());
        confirmation.setAddress(hotel.getAddress());
        confirmation.setRoomNumber(roomToBook.getRoomNumber());
        confirmation.setRoomType(RoomType.valueOf(roomToBook.getRoomType().name()));
        confirmation.setCheckInDate(request.getCheckInDate());
        confirmation.setCheckOutDate(request.getCheckOutDate());
        confirmation.setContact(hotel.getContact());
        confirmation.setTotalAmount(total);

        return confirmation;

    }


}
