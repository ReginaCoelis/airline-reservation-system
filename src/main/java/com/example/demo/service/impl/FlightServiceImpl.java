package com.example.demo.service.impl;


import com.example.demo.domain.Airline;
import com.example.demo.domain.Airport;
import com.example.demo.domain.Flight;
import com.example.demo.dto.request.FlightRequest;
import com.example.demo.dto.response.FlightResponse;
import com.example.demo.repository.AirlineRepository;
import com.example.demo.repository.AirportRepository;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private AirportRepository airportRepository;



    @Override
    public FlightResponse addFlight(FlightRequest requestFlight) {
        Airline airline= airlineRepository.findByCode(requestFlight.getAirline().getCode());
        Airport departureAirport= airportRepository.findByCode(requestFlight.getDepartureAirport().getCode());
        Airport originAirport= airportRepository.findByCode(requestFlight.getArrivalAirport().getCode());

        Flight flight=new Flight();
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(originAirport);
        flight.setFlightNumber(requestFlight.getFlightNumber());
        flight.setCapacity(requestFlight.getCapacity());
        flight.setDepartureTime(requestFlight.getDepartureTime());
        flight.setDepartureDate(requestFlight.getDepartureDate());
        flight.setArrivalTime(requestFlight.getArrivalTime());
        flight.setArrivalDate(requestFlight.getArrivalDate());
        flight.setAirline(airline);

        return covertFlightToFlightResponse(flightRepository.save(flight));
    }

    @Override
    public FlightResponse getFlightByNumber(Integer flightNumber) {
        return covertFlightToFlightResponse(flightRepository.getByFlightNumber(flightNumber));
    }

    @Override
    public List<FlightResponse> getAllFlights() {
        return flightRepository.findAll().stream().parallel().map(this::covertFlightToFlightResponse).collect(Collectors.toList());

    }

    private FlightResponse covertFlightToFlightResponse(Flight flight){
        return new FlightResponse(flight.getId(), flight.getFlightNumber(), flight.getCapacity(), flight.getDepartureAirport().getCode(), flight.getDepartureTime(),flight.getDepartureDate(),flight.getArrivalAirport().getCode(),flight.getArrivalTime(),flight.getArrivalDate(), flight.getAirline().getCode());

    }

}
