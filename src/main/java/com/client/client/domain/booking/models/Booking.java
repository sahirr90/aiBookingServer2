package com.client.client.domain.booking.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity // JPA to save to the database
@NoArgsConstructor // Non argument constructor
@RequiredArgsConstructor // parameterized constructor
@Data // getters and setters
@Table(name = "bookingDetails")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private BookingStatus bookingStatus;

    @NonNull
    private String destinationFrom;

    @NonNull
    private String destinationTo;

    @NonNull
    private LocalDate bookingFrom;

    @NonNull
    private LocalDate bookingTo;

    public String toString(){
        return String.format(" %s %s %s %s %s %s %s %s", firstName,lastName,email, bookingStatus, destinationFrom, destinationTo, bookingFrom, bookingTo);
    }

}