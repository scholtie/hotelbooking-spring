package com.cubicfox.hotelbooking.controller;

import com.cubicfox.hotelbooking.HotelbookingApplication;
import com.cubicfox.hotelbooking.ResourceNotFoundException;
import com.cubicfox.hotelbooking.model.Users;
import com.cubicfox.hotelbooking.repository.UsersRepository;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(HotelbookingApplication.class);

    @Autowired
    private UsersRepository repository;

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        logger.info("Get all the users...");
        return repository.findAll();
    }

    @GetMapping("/login")
    public ResponseEntity<Users> loginUser(@PathVariable(value = "id") long usersId) throws ResourceNotFoundException {
        logger.info("Get user by id...");
        Users users = repository.findById(usersId).
                orElseThrow(() -> new ResourceNotFoundException("User not found for this id:: " + usersId));
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable(value = "id") long usersId) throws ResourceNotFoundException {
        logger.info("Get user by id...");
        Users users = repository.findById(usersId).
                orElseThrow(() -> new ResourceNotFoundException("User not found for this id:: " + usersId));
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/users")
    public Users createUser(@Valid @RequestBody Users users) {
        logger.info("Insert user...");
        return repository.save(users);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Users> UserById(@PathVariable(value = "id") long usersId, @RequestBody Users updatedUser) throws ResourceNotFoundException {
        logger.info("Update user...");
        Users user = repository.findById(usersId).
                orElseThrow(() -> new ResourceNotFoundException("User not found for this id:: " + usersId));
        user.setUserName(updatedUser.getUserName());
        user.setEmail(updatedUser.getEmail());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setPassword(updatedUser.getPassword());
        repository.save(user);
        return ResponseEntity.ok().body(user);

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable(value = "id") long userId) throws ResourceNotFoundException {
        logger.info("Delete user...");
        Users user = repository.findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("User not found for this id:: " + userId));
        repository.delete(user);
    }
}