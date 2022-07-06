package com.cubicfox.hotelbooking.repository;

import com.cubicfox.hotelbooking.model.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<RoomReservation, Long> {
}
