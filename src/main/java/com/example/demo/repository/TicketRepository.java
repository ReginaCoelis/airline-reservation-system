package com.example.demo.repository;

import com.example.demo.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    public Ticket getTicketsByFlightNumber(Integer flightNumber);
    public Ticket getTicketsByFlightName(String flightName);
    public Ticket getTicketByPassengerName(String name);
    public Ticket getTicketByPassengerEmail(String email);
}
