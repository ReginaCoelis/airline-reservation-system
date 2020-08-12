package com.airline.reservation.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 4, nullable = false)
    private Integer flightNumber;

    @Column(nullable = false)
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "departureAirport_id")
    private Airport departureAirport;

    private LocalTime departureTime;

    private LocalDate departureDate;

    @ManyToOne
    @JoinColumn(name = "arrivalAirport_id")
    private Airport arrivalAirport;


    @OneToMany
    @JoinColumn(name = "flight_id")
    private List<Ticket> tickets;

    private LocalTime arrivalTime;

    private LocalDate arrivalDate;

    private Integer seatsAvailable;

    @ManyToOne
    @JoinColumn(name = "airlineid")
    private Airline airline;

    // default constructor
    public Flight() {
    }

}
