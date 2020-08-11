package com.example.demo.service;

import com.example.demo.dto.request.FlightRequest;
import com.example.demo.dto.request.PassengerRequest;
import com.example.demo.dto.response.PassengerResponse;
import com.example.demo.dto.response.TicketResponse;
import org.springframework.stereotype.Service;

@Service
public interface TicketService {
    public TicketResponse getTicketsByFlightNumber(Integer flightNumber);
//    public TicketResponse getTicketByPassengerName(String name);
}
