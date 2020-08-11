package com.example.demo.dto.response;

import java.util.Date;

public class TicketResponse {

    private Long id;
    private Integer flightNumber;
    private AirlineResponse airlineName;
    private AirlineResponse depratureAirport;
    private AirlineResponse arrivalAirport;
    private Date departureTime;
    private Date departureDate;
    private Date arrivalTime;
    private Date arrivalDate;

    private Date issuedAt;

    private ReservationResponse reservation;

    public TicketResponse() {
        super();
    }

    public TicketResponse(Integer flightNumber, AirlineResponse airlineName, AirlineResponse depratureAirport, AirlineResponse arrivalAirport,
                          Date departureTime, Date departureDate,
                          Date arrivalTime, Date arrivalDate, ReservationResponse reservation) {
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

    public AirlineResponse getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(AirlineResponse airlineName) {
        this.airlineName = airlineName;
    }

    public AirlineResponse getDepratureAirport() {
        return depratureAirport;
    }

    public void setDepratureAirport(AirlineResponse depratureAirport) {
        this.depratureAirport = depratureAirport;
    }

    public AirlineResponse getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(AirlineResponse arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }


    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
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

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public ReservationResponse getReservation() {
        return reservation;
    }

    public void setReservation(ReservationResponse reservation) {
        this.reservation = reservation;
    }


}