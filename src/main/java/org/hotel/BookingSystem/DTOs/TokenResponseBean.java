package org.hotel.BookingSystem.DTOs;

import lombok.Setter;

public class TokenResponseBean {
    private String message;
    @Setter
    private String name;
    @Setter
    private String email;
    @Setter
    private String phone;

    public TokenResponseBean(String message, String name, String email,  String phone) {
        this.message = message;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage() {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public String getPhone() {
        return phone;
    }

}
