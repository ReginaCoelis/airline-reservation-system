package com.airline.reservation.service;

import com.airline.reservation.domain.Airline;
import com.airline.reservation.dto.request.AirlineRequest;
import com.airline.reservation.dto.response.AirlineResponse;

import java.util.List;

public interface AirlineService {
    AirlineResponse saveAirline(AirlineRequest airline);

    AirlineResponse getAirlineById(Long id);

    AirlineResponse getAirlineByName(String name);

    List<AirlineResponse> getAirlineByAirportCode(String airportCode);

    List<AirlineResponse> getAllAirlines();

    void deleteAirline(Long id);

    void deleteAll();

    void updateAirline(Airline airline);

    void updateAirline(Long id, String code, String name);
}
