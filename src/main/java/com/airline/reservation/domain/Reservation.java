package com.airline.reservation.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String reservationCode;
    @ElementCollection
    @CollectionTable(name = "reservation_flight_numbers", joinColumns = @JoinColumn(name = "reservation_id"))
    @Column(name = "flight_number")
    private Set<Integer> flightNumbers;

    private Long passengerId;

    private Long madeByUserId;

    private Long madeByAgentId;

    private boolean isConfirmed;

    private boolean isCancelled;

    private Date createdAt;

    private Date lastUpdateDate;


}