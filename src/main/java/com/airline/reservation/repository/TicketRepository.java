package com.airline.reservation.repository;

import com.airline.reservation.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    public List<Ticket> getTicketsByFlightNumber(Integer flightNumber);

    public List<Ticket> getTicketsByPassengerId(Long id);

}
