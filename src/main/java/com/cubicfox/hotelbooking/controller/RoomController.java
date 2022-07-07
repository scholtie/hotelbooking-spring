package com.cubicfox.hotelbooking.controller;

import com.cubicfox.hotelbooking.HotelbookingApplication;
import com.cubicfox.hotelbooking.ResourceNotFoundException;
import com.cubicfox.hotelbooking.model.Room;
import com.cubicfox.hotelbooking.repository.RoomRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RoomController {

    private static final Logger logger = LoggerFactory.getLogger(HotelbookingApplication.class);

    @Autowired
    private RoomRepository repository;

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        logger.info("Get all the rooms...");
        return repository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") long roomId) throws ResourceNotFoundException {
        logger.info("Get user by id...");
        Room room = repository.findById(roomId).
                orElseThrow(() -> new ResourceNotFoundException("User not found for this id:: " + roomId));
        return ResponseEntity.ok().body(room);

    }

    @PostMapping("/rooms")
    public Room createRoom(@Valid @RequestBody Room room) {
        logger.info("Insert room...");
        return repository.save(room);
    }

    @DeleteMapping("/rooms/{id}")
    public void deleteRoom(@PathVariable(value = "id") long roomId) throws ResourceNotFoundException {
        logger.info("Delete room...");
        Room room = repository.findById(roomId).
                orElseThrow(() -> new ResourceNotFoundException("User not found for this id:: " + roomId));
        repository.delete(room);
    }
}
