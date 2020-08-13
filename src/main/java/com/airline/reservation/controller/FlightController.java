package com.airline.reservation.controller;

import com.airline.reservation.domain.Flight;
import com.airline.reservation.domain.Passenger;
import com.airline.reservation.dto.request.BookingRequest;
import com.airline.reservation.dto.request.FlightRequest;
import com.airline.reservation.dto.response.FlightResponse;
import com.airline.reservation.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class FlightController {

    @Autowired
    private FlightService flightService;


    @PostMapping("/flights")
    @ResponseStatus(HttpStatus.CREATED)
    public void addFlight(@RequestBody FlightRequest flightRequest){
        flightService.addFlight(flightRequest);
    }

    @GetMapping(value = "/flights/{flightNumber}")
    public FlightResponse getFlightByNumber(@PathVariable int flightNumber){
        return flightService.getFlightByNumber(flightNumber);
    }

    @GetMapping("/flights")
    public List<FlightResponse> getAllFlights(){
        return flightService.getAllFlights();
    }


    @RequestMapping(value = "/flights/passengers/{passengerId}", method = RequestMethod.GET)
    public Flight getFlightByPassenger(@PathVariable int passengerId) {
        return flightService.getFlightByPassengerId(passengerId);
    }

    @RequestMapping(value = "/bookings", method = RequestMethod.POST)
    public void bookFlight(@RequestBody BookingRequest bookingRequest) {
        flightService.bookFlight(bookingRequest);
    }

}
