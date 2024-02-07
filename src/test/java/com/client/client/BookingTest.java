package com.client.client;

import com.client.client.domain.booking.models.Booking;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.client.client.domain.booking.models.BookingStatus;

import java.time.LocalDate;


public class BookingTest {
    
    @Test
    public void testBookingConstructorAndGetters() {
        // Create a booking

        Booking booking = new Booking("John", "Doe", "john.doe@example.com",
                BookingStatus.CONFIRMED, "CityA", "CityB",
                LocalDate.of(2024, 2, 6), LocalDate.of(2024, 2, 10));

        // Verify getters
        assertEquals("John", booking.getFirstName());
        assertEquals("Doe", booking.getLastName());
        assertEquals("john.doe@example.com", booking.getEmail());
        assertEquals(BookingStatus.CONFIRMED, booking.getBookingStatus());
        assertEquals("CityA", booking.getDestinationFrom());
        assertEquals("CityB", booking.getDestinationTo());
        assertEquals(LocalDate.of(2024, 2, 6), booking.getBookingFrom());
        assertEquals(LocalDate.of(2024, 2, 10), booking.getBookingTo());
    }

    @Test
    public void testToString() {
        Booking booking = new Booking("Jane", "Smith", "jane.smith@example.com",
                BookingStatus.CONFIRMED, "CityX", "CityY",
                LocalDate.of(2024, 3, 15), LocalDate.of(2024, 3, 20));

        // Verify toString method
        String expectedToString = " Jane Smith jane.smith@example.com CONFIRMED CityX CityY 2024-03-15 2024-03-20";
        assertEquals(expectedToString, booking.toString());
    }
}
