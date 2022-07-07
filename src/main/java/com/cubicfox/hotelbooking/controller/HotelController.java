package com.cubicfox.hotelbooking.controller;

import com.cubicfox.hotelbooking.HotelbookingApplication;
import com.cubicfox.hotelbooking.model.Hotel;
import com.cubicfox.hotelbooking.model.Users;
import com.cubicfox.hotelbooking.repository.BookingRepository;
import com.cubicfox.hotelbooking.repository.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HotelController {

    private static final Logger logger = LoggerFactory.getLogger(HotelbookingApplication.class);

    @Autowired
    private HotelRepository repository;
    @GetMapping("/hotels")
    public List<Hotel> getAllHotels() {
        logger.info("Get all the hotels...");
        return repository.findAll();
    }
}
