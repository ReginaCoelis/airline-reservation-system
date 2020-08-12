package com.airline.reservation.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@NamedQuery(
        name="Ticket.getTicketsByPassengerId",
        query = "SELECT distinct t FROM Ticket t WHERE t.passenger.id=:id"
)
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;
    private Integer flightNumber;
    private String airlineName;
    private String depratureAirport;
    private String arrivalAirport;
    private LocalTime departureTime;
    private LocalDate departureDate;
    private LocalTime arrivalTime;
    private LocalDate arrivalDate;
    @CreationTimestamp
    private LocalDateTime issuedAt;
    @OneToOne
    @JoinColumn(name = "passenger_id",nullable = true)
    private Passenger passenger;

    @ManyToOne
    private Reservation reservation;

    public Ticket() {
        super();
    }

    public Ticket(Integer flightNumber, String airlineName, String depratureAirport, String arrivalAirport,
                  LocalTime departureTime, LocalDate departureDate,
                  LocalTime arrivalTime, LocalDate arrivalDate, Reservation reservation) {
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

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getDepratureAirport() {
        return depratureAirport;
    }

    public void setDepratureAirport(String depratureAirport) {
        this.depratureAirport = depratureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
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

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}