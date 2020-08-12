package com.airline.reservation.service;

import com.airline.reservation.domain.Ticket;

import java.util.List;

public interface TicketService {
    public List<Ticket> getTicketsByFlightNumber(Integer flightNumber);
}
