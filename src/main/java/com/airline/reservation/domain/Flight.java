package com.airline.reservation.domain;

import lombok.Data;

import javax.persistence.*;
<<<<<<< HEAD
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
=======
import javax.print.attribute.standard.MediaSize;
>>>>>>> master
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

    @OneToMany
    @JoinColumn(name = "flight_id")
    private List<Ticket> tickets;

    // default constructor
    public Flight() {
    }

<<<<<<< HEAD
=======
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getDepartureDate() { return departureDate; }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setDepartureTime(Date departureTime) { this.departureTime = departureTime; }

    public void setSeatsAvailable(Integer seatsAvailable) { this.seatsAvailable = seatsAvailable; }

    public Integer getSeatsAvailable() { return seatsAvailable; }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
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

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
>>>>>>> master
}
