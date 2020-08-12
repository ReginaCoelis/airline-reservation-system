package com.airline.reservation.service;

import com.airline.reservation.domain.Ticket;

import java.util.List;

public interface TicketService {
<<<<<<< HEAD
    public List<Ticket> getTicketsByFlightNumber(Integer flightNumber);
=======
    public List<TicketResponse> getTicketsByFlightNumber(Integer flightNumber);
    public List<TicketResponse> getTicketByPassengerId(Long id);
>>>>>>> master
}
