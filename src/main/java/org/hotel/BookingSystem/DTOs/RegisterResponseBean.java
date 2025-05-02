package org.hotel.BookingSystem.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseBean {
    private String message;
    private Long userId;
    private String name;
    private String email;


}
