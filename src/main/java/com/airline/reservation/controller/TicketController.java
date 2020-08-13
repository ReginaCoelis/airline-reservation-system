package com.airline.reservation.controller;

import com.airline.reservation.dto.response.TicketResponse;
import com.airline.reservation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/getAllTicketsByFlightNumber")
    public List<TicketResponse> getAllTicketsByFlightNumber(Integer flightNumber){
        return ticketService.getTicketsByFlightNumber(flightNumber);
    }

    @GetMapping("/getAllTicketsByPassengerId")
    public TicketResponse getAllTicketsByPassengerId(Long passengerId){
        return ticketService.getTicketByPassengerId(passengerId);
    }

    @GetMapping("/tickets/{passengerId}")
    public @ResponseBody TicketResponse getPassengerTicket(@PathVariable("passengerId") Long passengerId){
        return ticketService.getTicketByPassengerId(passengerId);
    }
}
