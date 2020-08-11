package com.airline.reservation.service;

import com.airline.reservation.domain.Ticket;
import com.airline.reservation.dto.response.TicketResponse;

import java.util.List;

public interface TicketService {
    public List<Ticket> getTicketsByFlightNumber(Integer flightNumber);
//    public TicketResponse getTicketsByFlightName(String flightName);
//    public TicketResponse getTicketByPassengerName(String name);
//    public TicketResponse getTicketByPassengerEmail(String email);
}
