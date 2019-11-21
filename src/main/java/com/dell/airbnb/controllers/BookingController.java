package com.dell.airbnb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dell.airbnb.entities.Booking;
import com.dell.airbnb.repositories.BookingRepository;

@RestController
public class BookingController {

    @Autowired
    BookingRepository repo;

    @GetMapping(value = "/bookings")
    public List<Booking> index() {
        return repo.getAll();
    }

    @PostMapping(value = "/bookings")
    public Booking create(@RequestBody Booking booking) {
        repo.addBooking(booking);
        return booking;
    }

    @PostMapping(value = "/bookings/{id}")
    public String updateBooking(@PathVariable("id") int bookingInt, @RequestBody Booking booking){
        repo.updateBooking(bookingInt,booking);

        return "Successfully Updated.";
    }
}