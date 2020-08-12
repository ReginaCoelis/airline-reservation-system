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
}