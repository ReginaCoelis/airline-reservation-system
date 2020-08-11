package com.airline.reservation.repository;

import com.airline.reservation.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    public List<Ticket> findByFlightNumber(Integer flightNumber);
//    public Ticket getTicketsByFlightName(String flightName);
//    public Ticket getTicketByPassengerName(String name);
//    public Ticket getTicketByPassengerEmail(String email);
}
