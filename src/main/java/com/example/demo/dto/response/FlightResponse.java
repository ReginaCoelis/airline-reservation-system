package com.example.demo.dto.response;

import java.util.Date;

public class FlightResponse {

    private Long id;
    private Integer flightNumber;
    private Integer capacity;
    private AirportResponse departureAirport;
    private Date departureTime;
    private Date departureDate;
    private AirportResponse arrivalAirport;
    private Date arrivalTime;
    private Date arrivalDate;
    private AirlineResponse airline;

    // default constructor
    public FlightResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public AirportResponse getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(AirportResponse departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getDepartureDate() {
        return departureDate;

    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;

    }

    public AirportResponse getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(AirportResponse arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public AirlineResponse getAirline() {
        return airline;
    }

    public void setAirline(AirlineResponse airline) {
        this.airline = airline;
    }
}
