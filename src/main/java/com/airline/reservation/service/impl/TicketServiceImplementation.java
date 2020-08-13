package com.airline.reservation.service.impl;

import com.airline.reservation.domain.Ticket;
import com.airline.reservation.dto.response.TicketResponse;
import com.airline.reservation.repository.TicketRepository;
import com.airline.reservation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class TicketServiceImplementation implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<TicketResponse> getTicketsByFlightNumber(Integer flightNumber) {
        return convertTicketsToTicketResponses(ticketRepository.findByFlightNumber(flightNumber));
    }

    @Override
    public TicketResponse getTicketByPassengerId(Long id) {
        Ticket ticket = ticketRepository.findByPassengerId(id);
        return new TicketResponse(ticket.getFlightNumber(), ticket.getAirlineName(), ticket.getDepratureAirport(),
                ticket.getArrivalAirport(), ticket.getDepartureTime(),
                ticket.getDepartureDate(), ticket.getArrivalTime(), ticket.getArrivalDate());
    }

    public List<TicketResponse> convertTicketsToTicketResponses(List<Ticket> ticket) {
        TicketResponse ticketResponse;
        List<TicketResponse> ticketResponses = new ArrayList<>();
        for (Ticket t : ticket) {
            ticketResponse = new TicketResponse(t.getFlightNumber(), t.getAirlineName(), t.getDepratureAirport(), t.getArrivalAirport(), t.getDepartureTime(),
                    t.getDepartureDate(), t.getArrivalTime(), t.getArrivalDate());
            ticketResponses.add(ticketResponse);
        }
        return ticketResponses;
    }

}

