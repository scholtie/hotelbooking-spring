package com.cubicfox.hotelbooking.controller;

import com.cubicfox.hotelbooking.HotelbookingApplication;
import com.cubicfox.hotelbooking.ResourceNotFoundException;
import com.cubicfox.hotelbooking.model.RoomReservation;
import com.cubicfox.hotelbooking.repository.BookingRepository;
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
public class ReservationController {

    private static final Logger logger = LoggerFactory.getLogger(HotelbookingApplication.class);

    @Autowired
    private BookingRepository repository;

    @GetMapping("/reservations")
    public List<RoomReservation> getAllReservations() {
        logger.info("Get all the reservations...");
        return repository.findAll();
    }

    @GetMapping("/reservations/{id}")
    public ResponseEntity<RoomReservation> getReservationById(@PathVariable(value = "id") long reservationId) throws ResourceNotFoundException {
        logger.info("Get reservation by id...");
        RoomReservation reservation = repository.findById(reservationId).
                orElseThrow(() -> new ResourceNotFoundException("User not found for this id:: " + reservationId));
        return ResponseEntity.ok().body(reservation);

    }

    @PostMapping("/reservations")
    public RoomReservation createReservation(@Valid @RequestBody RoomReservation reservation) {
        logger.info("Insert reservation...");
        return repository.save(reservation);
    }

    @PutMapping("/reservaions/{id}")
    public ResponseEntity<RoomReservation> ReservationById(@PathVariable(value = "id") long reservationId, @RequestBody RoomReservation updatedReservation) throws ResourceNotFoundException {
        logger.info("Update user...");
        RoomReservation reservation = repository.findById(reservationId).
                orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + reservationId));
        reservation.setDate_in(updatedReservation.getDate_in());
        reservation.setDate_out(updatedReservation.getDate_out());
        reservation.setRoom(updatedReservation.getRoom());
        reservation.setStatus(updatedReservation.getStatus());
        repository.save(reservation);
        return ResponseEntity.ok().body(reservation);

    }

    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable(value = "id") long reservationId) throws ResourceNotFoundException {
        logger.info("Delete reservation...");
        RoomReservation reservation = repository.findById(reservationId).
                orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + reservationId));
        repository.delete(reservation);
    }
}
