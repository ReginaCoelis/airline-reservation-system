package com.airline.reservation.service;

import com.airline.reservation.domain.Flight;
import com.airline.reservation.domain.Passenger;
import com.airline.reservation.dto.request.FlightRequest;
import com.airline.reservation.dto.response.FlightResponse;

import java.util.List;


public interface FlightService {
    public FlightResponse addFlight(FlightRequest requestFlight );
    public FlightResponse getFlightByNumber(Integer FlightNumber);
    public List<FlightResponse>getAllFlights();
    public Flight getFlightByPassengerId(Integer passengerId);
    public void bookFlight(int flightId, Passenger passenger);

}
