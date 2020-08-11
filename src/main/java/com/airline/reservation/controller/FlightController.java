package com.airline.reservation.controller;

import com.airline.reservation.domain.Flight;
import com.airline.reservation.domain.Passenger;
import com.airline.reservation.service.impl.FlightServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlightController {

    private FlightServiceImpl flightService;

    @Autowired
    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(value = "/flight/{passengerId}", method = RequestMethod.GET)
    public Flight getFlightByPassenger(@PathVariable int passengerId) {
        return flightService.getFlightByPassengerId(passengerId);
    }

    @RequestMapping(value = "/bookings", method = RequestMethod.POST)
    public void bookFlight(@RequestBody int flightId, Passenger passenger) {
        flightService.bookFlight(flightId, passenger);
    }

}
