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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public Set<Integer> getFlightNumbers() {
        return flightNumbers;
    }

    public void setFlightNumbers(Set<Integer> flightNumbers) {
        this.flightNumbers = flightNumbers;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Long getMadeByUserId() {
        return madeByUserId;
    }

    public void setMadeByUserId(Long madeByUserId) {
        this.madeByUserId = madeByUserId;
    }

    public Long getMadeByAgentId() {
        return madeByAgentId;
    }

    public void setMadeByAgentId(Long madeByAgentId) {
        this.madeByAgentId = madeByAgentId;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    private Date lastUpdateDate;


}