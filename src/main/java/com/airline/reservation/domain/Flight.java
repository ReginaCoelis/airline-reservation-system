package com.airline.reservation.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
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

    private Integer seatsAvailable;

    @ManyToOne
    @JoinColumn(name = "arrivalAirport_id")
    private Airport arrivalAirport;


    @OneToMany
    @JoinColumn(name = "flight_id")
    private List<Ticket> tickets;

    private LocalTime arrivalTime;

    private LocalDate arrivalDate;

    @ManyToOne
    @JoinColumn(name = "airlineid")
    private Airline airline;

    // default constructor
    public Flight() {
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

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setSeatsAvailable(Integer seatsAvailable) { this.seatsAvailable = seatsAvailable; }

    public Integer getSeatsAvailable() { return seatsAvailable; }
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

}
