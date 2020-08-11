package com.example.demo.service.Implementation;

import com.example.demo.domain.Ticket;
import com.example.demo.dto.response.TicketResponse;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TicketServiceImplementation implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponse getTicketsByFlightNumber(Integer flightNumber) {
        return convertTicketToTicketResponse(ticketRepository.getTicketsByFlightNumber(flightNumber));
    }

//    @Override
//    public TicketResponse getTicketByPassengerName(String name) {
//        return convertTicketToTicketResponse(ticketRepository.getTicketByPassengerName(name));
//    }

    public TicketResponse convertTicketToTicketResponse(Ticket ticket){
        return new TicketResponse(ticket.getFlightNumber(), ticket.getAirlineName(), ticket.getDepratureAirport(), ticket.getArrivalAirport(), ticket.getDepartureTime(),
                ticket.getDepartureDate(), ticket.getArrivalTime(), ticket.getArrivalDate());
    }
}
