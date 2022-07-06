package com.cubicfox.hotelbooking.repository;

import com.cubicfox.hotelbooking.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
