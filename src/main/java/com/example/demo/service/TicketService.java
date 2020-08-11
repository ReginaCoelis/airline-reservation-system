package com.example.demo.service;

import com.example.demo.dto.request.FlightRequest;
import com.example.demo.dto.request.PassengerRequest;
import com.example.demo.dto.response.PassengerResponse;
import com.example.demo.dto.response.TicketResponse;

import java.util.List;

public interface TicketService {
    public List<TicketResponse> getTicketsByFlightNumber(Integer flightNumber);
    public List<TicketResponse> getTicketByPassengerId(Long id);
}
