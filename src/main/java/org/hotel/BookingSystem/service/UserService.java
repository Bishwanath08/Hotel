package org.hotel.BookingSystem.service;

import org.hotel.BookingSystem.Bean.BeanLogin;
import org.hotel.BookingSystem.Bean.BeanRegister;
import org.hotel.BookingSystem.DTOs.OtpRequest;
import org.hotel.BookingSystem.enums.UserType;
import org.hotel.BookingSystem.model.Hotel;
import org.hotel.BookingSystem.model.User;
import org.hotel.BookingSystem.repository.HotelRepository;
import org.hotel.BookingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
   private HotelRepository hotelRepository;

    @Autowired
   private HotelService hotelService;



    public User registerAdmin(BeanRegister beanRegister) throws  Exception{
        User user = userRepo.findByEmail(beanRegister.getEmail());
        if (user!=null) {
            throw new Exception("Email already register");
        }
        user = new User();
        user.setName(beanRegister.getName());
        user.setEmail(beanRegister.getEmail());
        user.setPassword(beanRegister.getPassword());
        user.setPhone(beanRegister.getPhone());
        user.setUserType(UserType.ADMIN);
        return userRepo.save(user);
    }

    public User loginAdmin(BeanLogin beanLogin) throws  Exception{
        User user = userRepo.findByEmail((beanLogin.getEmail()));

        if(user == null) {
            throw new Exception("User not found! ");
        }
        if (!user.getPassword().equals(user.getPassword())){
            throw new Exception(("Invalid password"));
        }
        String token = UUID.randomUUID()+"_"+UUID.randomUUID();
        user.setToken(token);
        userRepo.save(user);
        return user;
    }

    public User getAdminByToken(String token) {
        User user = userRepo.findByToken(token);
        if (user==null) {
            throw new RuntimeException("Invalid token or user not found ");
        }
        return user;
    }

    public void validateAdmin(String token) throws  Exception {
        User user = userRepo.findByToken(token);
        if (user == null || user.getUserType() != UserType.ADMIN) {
            throw new Exception("Access Denied: Admin privileges required.");
        }
    }



    public User registerCustomer(BeanRegister beanRegister) throws Exception{
       User user= userRepo.findByEmail(beanRegister.getEmail());
        if (user!=null) {
            throw new Exception("Email already register");
        }
        user=new User();
        user.setName(beanRegister.getName());
        user.setEmail(beanRegister.getEmail());
        user.setPassword(beanRegister.getPassword());
        user.setPhone(beanRegister.getPhone());
        user.setUserType(UserType.CUSTOMER);

        return userRepo.save(user);
    }

    public User loginCustomer(BeanLogin beanLogin) throws Exception{
        User user = userRepo.findByEmail(beanLogin.getEmail());

        if (user==null) {
            throw new Exception("User Not Found!");
        }

        if (!user.getPassword().equals(user.getPassword())) {
            throw new Exception("Invalid password");
        }

//        String token = jwtUtil.generateToken(user.getEmail());

        String token = UUID.randomUUID()+"_"+UUID.randomUUID();
        user.setToken(token);
        user.setOtp(generateOTP(4));
        LocalDateTime futureTime = LocalDateTime.now().plusMinutes(5);

        user.setOtpGeneratedTime(futureTime);
        userRepo.save(user);

        return user;
    }

    public User getUserByToken(String token) {
        User user = userRepo.findByToken(token);
        if (user==null) {
            throw new RuntimeException("Invalid token or user not found ");
        }
        return user;
    }

    public String generateOTP(int length) {
        String digits = "0123456789";
        StringBuilder otp = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            otp.append(digits.charAt(random.nextInt(digits.length())));
        }
        System.out.println("YOUR OTP IS ::::: " + 1111);
        return "1111";
    }

    public User verifyOtp(String email, String otp) {
        Optional<User> userOtp = Optional.ofNullable(userRepo.findByEmail(email));

        if (userOtp.isPresent()) {
            User user  = userOtp.get();

            if (user.getOtp().equals(otp)) {
                if (user.getOtpGeneratedTime().isAfter(LocalDateTime.now()))
                {
                    user.setOtpGeneratedTime(LocalDateTime.now());
                    user.setEmail(user.getEmail());
                    user.setName(user.getName());
                    user.setPhone(user.getPhone());
                    userRepo.save(user);
                    return user;
                }
            } else {
                throw new RuntimeException("Invalid OTP");
            }
        } else {
            throw new RuntimeException("User not Found");
        }
        return null;
    }

}
