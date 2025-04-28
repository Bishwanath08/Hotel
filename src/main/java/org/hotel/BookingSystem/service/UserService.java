package org.hotel.BookingSystem.service;

import org.hotel.BookingSystem.Bean.BeanHotelFilter;
import org.hotel.BookingSystem.Bean.BeanLogin;
import org.hotel.BookingSystem.Bean.BeanRegister;
import org.hotel.BookingSystem.enums.UserType;
import org.hotel.BookingSystem.model.Hotel;
import org.hotel.BookingSystem.model.User;
import org.hotel.BookingSystem.repository.HotelRepository;
import org.hotel.BookingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelService hotelService;



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
}
