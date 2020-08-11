package com.example.demo.service;

import com.example.demo.domain.Flight;
import com.example.demo.domain.Passenger;
import com.example.demo.dto.request.FlightRequest;
import com.example.demo.dto.response.FlightResponse;
import com.example.demo.service.impl.FlightServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FlightService {
    public FlightResponse addFlight(FlightRequest requestFlight );
    public FlightResponse getFlightByNumber(Integer FlightNumber);
    public List<FlightResponse>getAllFlights();
    public Flight getFlightByPassengerId(Integer passengerId);
    public void bookFlight(int flightId, Passenger passenger);

}
