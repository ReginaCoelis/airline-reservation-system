package com.airline.reservation.service.impl;

import com.airline.reservation.domain.Airline;
import com.airline.reservation.dto.request.AirlineRequest;
import com.airline.reservation.dto.response.AirlineResponse;
import com.airline.reservation.repository.AirlineRepository;
import com.airline.reservation.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    AirlineRepository airlineRepository;

    @Override
    public AirlineResponse saveAirline(AirlineRequest airlineRequest) {
        Airline airline = new Airline();
        airline.setCode(airlineRequest.getCode());
        airline.setHistory(airlineRequest.getHistory());
        airline.setName(airlineRequest.getName());
        return convertAirlineToAirlineResponse(airlineRepository.save(airline));
    }

    @Override
    public AirlineResponse getAirlineById(Long id) {
        return airlineRepository.findById(id).map(this::convertAirlineToAirlineResponse).get();
    }

    @Override
    public AirlineResponse getAirlineByName(String name) {
        return convertAirlineToAirlineResponse(airlineRepository.findByName(name));
    }

    @Override
    public List<AirlineResponse> getAirlineByAirportCode(String airportCode) {
        return convertAirlinesToAirlineResponses(airlineRepository.getAllAirlinesOutOfAnAirport(airportCode));
    }

    @Override
    public List<AirlineResponse> getAllAirlines() {
        return airlineRepository.findAll().stream().parallel().map(this::convertAirlineToAirlineResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        airlineRepository.deleteAll();
    }

    @Override
    public void updateAirline(Airline airline) {
        airlineRepository.save(airline);
    }

    @Override
    public void updateAirline(Long id, String code, String name) {
        Airline airline = airlineRepository.getOne(id);
        airline.setName(name);
        airline.setCode(code);

        updateAirline(airline);
    }

    public AirlineResponse convertAirlineToAirlineResponse(Airline airline){
        return new AirlineResponse(airline.getId(), airline.getCode(), airline.getName(), airline.getHistory());
    }

    public List<AirlineResponse> convertAirlinesToAirlineResponses(List<Airline> airlines){
        AirlineResponse airlineResponse;
        List<AirlineResponse> responseList = new ArrayList<>();
        for(Airline airline : airlines){
            airlineResponse = new AirlineResponse(airline.getId(),airline.getCode(),airline.getName(), airline.getHistory());
            responseList.add(airlineResponse);
        }
        return responseList;
    }
}
