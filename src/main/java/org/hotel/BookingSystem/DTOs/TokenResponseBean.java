package org.hotel.BookingSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class TokenResponseBean {
    private String message;
    @Setter
    private String name;
    @Setter
    private String email;
    @Setter
    private String phone;


}
