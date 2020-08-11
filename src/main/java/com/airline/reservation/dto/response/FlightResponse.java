package com.airline.reservation.dto.response;

import java.util.Date;

public class FlightResponse {

    private Long id;
    private Integer flightNumber;
    private Integer capacity;
    private String departureAirport;
    private Date departureTime;
    private Date departureDate;
    private String arrivalAirport;
    private Date arrivalTime;
    private Date arrivalDate;
    private String airline;

    // default constructor
    public FlightResponse() {
    }

    public FlightResponse(Long id, Integer flightNumber, Integer capacity, String departureAirport, Date departureTime, Date departureDate, String arrivalAirport, Date arrivalTime, Date arrivalDate, String airline) {
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

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
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

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
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

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
