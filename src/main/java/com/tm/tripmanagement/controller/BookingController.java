package com.tm.tripmanagement.controller;

import com.tm.tripmanagement.entities.Booking;
import com.tm.tripmanagement.entities.FamilyMember;
import com.tm.tripmanagement.entities.User;
import com.tm.tripmanagement.repository.BookingRepository;
import com.tm.tripmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {

        if (booking.getUser() == null || booking.getUser().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User is required");
        }

        User user = userRepository.findById(booking.getUser().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));


        booking.setUser(user);


        if (booking.getDepartureSource() == null || booking.getDepartureDestination() == null
                || booking.getDepartureTime() == null || booking.getCategory() == null
                || booking.getVendor() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required fields");
        }


        if (booking.getFamilyMembers() != null) {
            for (FamilyMember familyMember : booking.getFamilyMembers()) {
                familyMember.setBooking(booking);
            }
        }


        return bookingRepository.save(booking);
    }



    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void cancelBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
    }
}