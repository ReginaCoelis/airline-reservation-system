package com.airline.reservation.controller;

import com.airline.reservation.domain.Flight;
import com.airline.reservation.domain.Passenger;
import com.airline.reservation.dto.request.FlightRequest;
import com.airline.reservation.dto.response.FlightResponse;
import com.airline.reservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/")
    public String hello() {
        return "Welcome To The Airline Reservation Application";
    }

    @PostMapping
    public String addFlight(@RequestBody FlightRequest flightRequest){
        flightService.addFlight(flightRequest);
        return "redirect:/flights/list";
    }

    @GetMapping(value = "/flights/{flightNumber}")
    public FlightResponse getFlightByNumber(@PathVariable int flightNumber){
        return flightService.getFlightByNumber(flightNumber);
    }

    @GetMapping
    public List<FlightResponse> getAllFlights(){
        return flightService.getAllFlights();
    }


    @RequestMapping(value = "/flights/passengers/{passengerId}", method = RequestMethod.GET)
    public Flight getFlightByPassenger(@PathVariable int passengerId) {
        return flightService.getFlightByPassengerId(passengerId);
    }

    @RequestMapping(value = "/bookings", method = RequestMethod.POST)
    public void bookFlight(@RequestBody int flightId, Passenger passenger) {
        flightService.bookFlight(flightId, passenger);
    }

}
