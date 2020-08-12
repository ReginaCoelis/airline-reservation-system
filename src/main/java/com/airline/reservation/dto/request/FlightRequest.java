package com.airline.reservation.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class FlightRequest {

    private Long id;
    private Integer flightNumber;
    private Integer capacity;
    private String departureAirport;
    private LocalTime departureTime;
    private LocalDate departureDate;
    private String arrivalAirport;
    private LocalTime arrivalTime;
    private LocalDate arrivalDate;
    private String airlineCode;

    // default constructor
    public FlightRequest() {
    }


    public FlightRequest(Integer flightNumber, Integer capacity, String departureAirport, LocalTime departureTime,
                         LocalDate departureDate,
                         String arrivalAirport, LocalTime arrivalTime, LocalDate arrivalDate, String airlineCode) {
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.arrivalAirport = arrivalAirport;
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        this.airlineCode = airlineCode;
    }


}
