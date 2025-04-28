package org.hotel.BookingSystem.service;

import org.hotel.BookingSystem.Bean.BeanHotelDetails;
import org.hotel.BookingSystem.Bean.BeanHotelFilter;
import org.hotel.BookingSystem.Bean.BeanRoomDetails;
import org.hotel.BookingSystem.Exception.ResourceNotFoundException;
import org.hotel.BookingSystem.model.Hotel;
import org.hotel.BookingSystem.model.Room;
import org.hotel.BookingSystem.repository.HotelRepository;
import org.hotel.BookingSystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private RoomRepository roomRepository;

    public Hotel addHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    public Hotel updateHotel(Long id, Hotel updatedHotel) throws Exception {
        Hotel hotel = hotelRepo.findById(id).orElseThrow(() -> new Exception("Hotel not found!"));
        hotel.setName(updatedHotel.getName());
        hotel.setAddress(updatedHotel.getAddress());
        hotel.setCity(updatedHotel.getCity());
        hotel.setContact(updatedHotel.getContact());
        return hotelRepo.save(hotel);
    }

    public void deleteHotel(Long id) throws  Exception{
        Hotel hotel = hotelRepo.findById(id).orElseThrow(() -> new Exception("Hotel not found!"));
        hotelRepo.delete(hotel);
    }

    public List<Hotel> getFilteredHotels(BeanHotelFilter filter) {
        return hotelRepo.findHotelsByfilter(filter.getCity(), filter.getMinPrice(), filter.getMaxPrice(), filter.getRoomType(), filter.getSearching());
    }

    public BeanHotelDetails getHotelDetails(Long hotelId) throws ResourceNotFoundException {
        Optional<Hotel> hotel = hotelRepo.findById(hotelId);
        if (hotel.isEmpty()) {
            throw new ResourceNotFoundException("Hotel Not Found with Give ID! :") ;
        }
        List<Room> roomList = roomRepository.findByHotelId(hotelId);
        if (roomList.isEmpty()){
            System.out.println("Room not Available");
        }
        List<BeanRoomDetails> beanRoomDetailsList = new ArrayList<>();
        BeanHotelDetails beanHotelDetails = new BeanHotelDetails();
        beanHotelDetails.setName(hotel.get().getName());
        beanHotelDetails.setAddress(hotel.get().getAddress());
        beanHotelDetails.setCity(hotel.get().getCity());
        beanHotelDetails.setContact(hotel.get().getContact());
        for (Room room : roomList) {
            BeanRoomDetails beanRoomDetails = new BeanRoomDetails();
            beanRoomDetails.setRoomType(room.getRoomType());
            beanRoomDetails.setAvailable(room.isAvailable());
            beanRoomDetails.setPrice(room.getPrice());
            beanRoomDetailsList.add(beanRoomDetails);
        }
        beanHotelDetails.setBeanRoomDetailroomList(beanRoomDetailsList);
        return beanHotelDetails;
    }
}
