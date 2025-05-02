package org.hotel.BookingSystem.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hotel.BookingSystem.enums.UserType;

import java.time.LocalDateTime;


@Entity

@Table(name = "users")

@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String phone;

    @Column(name = "otp")
    private String otp;

    @Column(name = "otp_generated_time")
    private LocalDateTime otpGeneratedTime;

    @Column(unique = true)
    private String token;

    @Enumerated(EnumType.STRING)
    private UserType userType;


}
