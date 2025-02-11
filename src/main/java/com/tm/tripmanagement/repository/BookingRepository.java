package com.tm.tripmanagement.repository;


import com.tm.tripmanagement.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}