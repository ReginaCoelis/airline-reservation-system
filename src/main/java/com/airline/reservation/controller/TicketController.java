package com.airline.reservation.controller;

import com.airline.reservation.dto.response.TicketResponse;
import com.airline.reservation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/getAllTicketsByFlightNumber")
    public List<TicketResponse> getAllTicketsByFlightNumber(Integer flightNumber){
        return ticketService.getTicketsByFlightNumber(flightNumber);
    }

    @GetMapping("/getAllTicketsByPassengerId")
    public List<TicketResponse> getAllTicketsByPassengerId(Long passengerId){
        return ticketService.getTicketByPassengerId(passengerId);
    }
}
