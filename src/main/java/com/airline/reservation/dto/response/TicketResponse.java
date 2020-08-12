package com.airline.reservation.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class TicketResponse {

    private Long id;
    private Integer flightNumber;
    private String airlineName;
    private String depratureAirport;
    private String arrivalAirport;
    private LocalTime departureTime;
    private LocalDate departureDate;
    private LocalTime arrivalTime;
    private LocalDate arrivalDate;

    private Date issuedAt;

    private ReservationResponse reservation;

    public TicketResponse() {
        super();
    }

    public TicketResponse(Integer flightNumber, String airlineName, String depratureAirport, String arrivalAirport,
                          LocalTime departureTime, LocalDate departureDate,
                          LocalTime arrivalTime, LocalDate arrivalDate) {
        //, ReservationResponse reservation
        super();
        this.flightNumber = flightNumber;
        this.airlineName = airlineName;
        this.depratureAirport = depratureAirport;
        this.arrivalAirport = arrivalAirport;

        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        this.reservation =reservation;
    }

}