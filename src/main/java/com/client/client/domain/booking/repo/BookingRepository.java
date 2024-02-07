package com.client.client.domain.booking.repo;

import com.client.client.domain.booking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long>{
    Optional<Booking> findByEmail(String email);
}

