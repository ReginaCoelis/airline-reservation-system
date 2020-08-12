package com.airline.reservation.service;


import com.airline.reservation.domain.Flight;
import com.airline.reservation.domain.Passenger;
import com.airline.reservation.dto.request.FlightRequest;
import com.airline.reservation.dto.response.FlightResponse;


import java.util.List;
import java.util.concurrent.ExecutionException;

public interface FlightService {
    public FlightResponse addFlight(FlightRequest flightRequest );
    public FlightResponse getFlightByNumber(Integer FlightNumber);
    public List<FlightResponse>getAllFlights();
    public Flight getFlightByPassengerId(Integer passengerId);
    public void bookFlight(int flightId, Passenger passenger);
    public void notifyUpcomingFlights() throws ExecutionException, InterruptedException;

}
