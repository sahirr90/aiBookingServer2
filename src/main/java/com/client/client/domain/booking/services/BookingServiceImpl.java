package com.client.client.domain.booking.services;

import com.client.client.domain.booking.models.Booking;
import com.client.client.domain.booking.repo.BookingRepository;
import com.client.client.domain.core.exception.ResourceCreationException;
import com.client.client.domain.core.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;


@Service
    public class BookingServiceImpl implements BookingService{
        private BookingRepository bookingRepository;

        @Autowired
        public BookingServiceImpl(BookingRepository bookingRepository) {
            this.bookingRepository = bookingRepository;
        }

        @Override
        public Booking create(Booking booking) throws ResourceCreationException {
            Optional<Booking> optional = bookingRepository.findByEmail(booking.getEmail());
            if(optional.isPresent())
                throw new ResourceCreationException("Booking with email exists: " + booking.getEmail());
            booking = bookingRepository.save(booking);
            return booking;
        }

        @Override
        public Booking getById(Long id) throws ResourceNotFoundException {
            Booking booking = bookingRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("No Booking with id: " + id));
            return booking;
        }

        @Override
        public Booking getByEmail(String email) throws ResourceNotFoundException {
            Booking booking = bookingRepository.findByEmail(email)
                    .orElseThrow(()->new ResourceNotFoundException("No Booking with email: " + email));
            return booking;
        }

        @Override
        public List<Booking> getAll() {
            return bookingRepository.findAll();
        }

        @Override
        public Booking update(Long id, Booking bookingDetail) throws ResourceNotFoundException {
            Booking booking = getById(id);
            booking.setFirstName(bookingDetail.getFirstName());
            booking.setLastName(bookingDetail.getLastName());
            booking.setEmail(bookingDetail.getEmail());
            booking.setBookingTo(bookingDetail.getBookingTo());
            booking.setBookingFrom(bookingDetail.getBookingFrom());
            booking.setBookingStatus(bookingDetail.getBookingStatus());
            booking.setDestinationFrom(bookingDetail.getDestinationFrom());
            booking.setDestinationTo(bookingDetail.getDestinationTo());






            booking = bookingRepository.save(booking);
            return booking;
        }

        @Override
        public void delete(Long id) {
            Booking booking = getById(id);
            bookingRepository.delete(booking);
        }
    }

