package com.airline.reservation.service.impl;

import com.airline.reservation.domain.Ticket;
import com.airline.reservation.dto.response.TicketResponse;
import com.airline.reservation.repository.TicketRepository;
import com.airline.reservation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TicketServiceImplementation implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<TicketResponse> getTicketsByFlightNumber(Integer flightNumber) {
        return convertTicketsToTicketResponses(ticketRepository.getTicketsByFlightNumber(flightNumber));
    }

    @Override
    public List<TicketResponse> getTicketByPassengerId(Long id) {
        return convertTicketsToTicketResponses(ticketRepository.getTicketsByPassengerId(id));
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