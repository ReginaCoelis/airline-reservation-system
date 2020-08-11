package com.airline.reservation.dto.request;

import java.util.Date;

public class FlightRequest {

    private Long id;
    private Integer flightNumber;
    private Integer capacity;
    private AirportRequest departureAirport;
    private Date departureTime;
    private Date departureDate;
    private AirportRequest arrivalAirport;
    private Date arrivalTime;
    private Date arrivalDate;
    private AirlineRequest airline;

    // default constructor
    public FlightRequest() {
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

    public AirportRequest getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(AirportRequest departureAirport) {
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

    public AirportRequest getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(AirportRequest arrivalAirport) {
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

    public AirlineRequest getAirline() {
        return airline;
    }

    public void setAirline(AirlineRequest airline) {
        this.airline = airline;
    }
}
