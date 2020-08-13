package com.airline.reservation.service;

import com.airline.reservation.dto.response.TicketResponse;

import java.util.List;

public interface TicketService {
    public List<TicketResponse> getTicketsByFlightNumber(Integer flightNumber);
    public TicketResponse getTicketByPassengerId(Long id);
}
