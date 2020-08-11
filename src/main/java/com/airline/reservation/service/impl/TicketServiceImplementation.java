package com.airline.reservation.service.impl;

import com.airline.reservation.domain.Ticket;
import com.airline.reservation.dto.response.TicketResponse;
import com.airline.reservation.repository.TicketRepository;
import com.airline.reservation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TicketServiceImplementation implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> getTicketsByFlightNumber(Integer flightNumber) {
        return ticketRepository.findByFlightNumber(flightNumber);
    }

//    @Override
//    public TicketResponse getTicketsByFlightName(String flightName) {
//        return convertTicketToTicketResponse(ticketRepository.getTicketsByFlightName(flightName));
//    }
//
//    @Override
//    public TicketResponse getTicketByPassengerName(String name) {
//        return convertTicketToTicketResponse(ticketRepository.getTicketByPassengerName(name));
//    }
//
//    @Override
//    public TicketResponse getTicketByPassengerEmail(String email) {
//        return convertTicketToTicketResponse(ticketRepository.getTicketByPassengerEmail(email));
//    }
//
//    public TicketResponse convertTicketToTicketResponse(Ticket ticket){
//        return new TicketResponse(ticket.getFlightNumber(), ticket.getAirlineName(), ticket.getDepratureAirport(), ticket.getArrivalAirport(), ticket.getDepartureTime(),
//                ticket.getDepartureDate(), ticket.getArrivalTime(), ticket.getArrivalDate());
//    }
}
