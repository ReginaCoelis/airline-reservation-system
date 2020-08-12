package com.airline.reservation.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class FlightResponse {

    private Long id;
    private Integer flightNumber;
    private Integer capacity;
    private String departureAirport;
    private LocalTime departureTime;
    private LocalDate departureDate;
    private String arrivalAirport;
    private LocalTime arrivalTime;
    private LocalDate arrivalDate;
    private String airline;

    // default constructor
    public FlightResponse() {
    }

    public FlightResponse(Long id, Integer flightNumber, Integer capacity, String departureAirport, LocalTime departureTime, LocalDate departureDate, String arrivalAirport, LocalTime arrivalTime, LocalDate arrivalDate, String airline) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.arrivalAirport = arrivalAirport;
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        this.airline = airline;
    }
}
