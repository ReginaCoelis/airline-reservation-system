package com.airline.reservation.service.impl;

import com.airline.reservation.domain.Ticket;
import com.airline.reservation.dto.response.TicketResponse;
import com.airline.reservation.repository.TicketRepository;
import com.airline.reservation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TicketServiceImplementation implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> getTicketsByFlightNumber(Integer flightNumber) {
        return ticketRepository.findByFlightNumber(flightNumber);
    }


}
