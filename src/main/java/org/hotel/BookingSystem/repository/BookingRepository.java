package org.hotel.BookingSystem.repository;

import org.hotel.BookingSystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BookingRepository extends JpaRepository<Booking, Long> {

}
