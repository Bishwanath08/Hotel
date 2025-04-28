package org.hotel.BookingSystem.Bean;

import java.util.List;

public class BeanHotelDetails {
    private String name;
    private String address;
    private String city;
    private String contact;

    private List<BeanRoomDetails> beanRoomDetailroomList;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<BeanRoomDetails> getBeanRoomDetailroomList() {
        return beanRoomDetailroomList;
    }

    public void setBeanRoomDetailroomList(List<BeanRoomDetails> beanRoomDetailroomList) {
        this.beanRoomDetailroomList = beanRoomDetailroomList;
    }
}
