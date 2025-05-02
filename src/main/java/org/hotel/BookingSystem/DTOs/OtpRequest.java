package org.hotel.BookingSystem.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtpRequest {

    private  String name;
    private String email;
     private String phone;
    private String otp;

}
