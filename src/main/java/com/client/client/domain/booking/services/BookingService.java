package com.client.client.domain.booking.services;

import com.client.client.domain.booking.models.Booking;
import com.client.client.domain.core.exception.ResourceCreationException;
import com.client.client.domain.core.exception.ResourceNotFoundException;

import java.util.List;

public interface BookingService {

    Booking create(Booking booking) throws ResourceCreationException;
    Booking getById(Long id) throws ResourceNotFoundException;
    Booking getByEmail(String email) throws ResourceNotFoundException;
    List<Booking> getAll();
    Booking update(Long id, Booking bookingDetails) throws ResourceNotFoundException;
    void delete(Long id);
}
