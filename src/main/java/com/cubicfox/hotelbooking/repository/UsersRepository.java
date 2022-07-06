package com.cubicfox.hotelbooking.repository;

import com.cubicfox.hotelbooking.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
