package com.example.demo.dto;

import java.util.Date;

public class FlightDto {

    private Long id;
    private Integer flightNumber;
    private Integer capacity;
    private AirportDto departureAirport;
    private Date departureTime;
    private Date departureDate;
    private AirportDto arrivalAirport;
    private Date arrivalTime;
    private Date arrivalDate;
    private AirlineDto airline;

    // default constructor
    public FlightDto() {
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

    public AirportDto getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(AirportDto departureAirport) {
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

    public AirportDto getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(AirportDto arrivalAirport) {
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

    public AirlineDto getAirline() {
        return airline;
    }

    public void setAirline(AirlineDto airline) {
        this.airline = airline;
    }
}
