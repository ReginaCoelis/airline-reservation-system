package com.airline.reservation.service.impl;

import com.airline.reservation.domain.Address;
import com.airline.reservation.domain.Airport;
import com.airline.reservation.dto.request.AirportRequest;
import com.airline.reservation.dto.response.AirportResponse;
import com.airline.reservation.repository.AirportRepository;
import com.airline.reservation.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

    @Autowired
    AirportRepository airportRepository;

    @Override
    public void addAirport(AirportRequest requestAirport) {
        Airport airport = new Airport();
        airport.setCode(requestAirport.getCode());
        airport.setName(requestAirport.getName());
        airport.setAddress(requestAirport.getAddress());

        airportRepository.save(airport);

    }

    @Override
    public List<AirportResponse> getAllAirports() {
        return airportRepository.findAll().stream()
                .map(airport -> new AirportResponse(airport.getCode(), airport.getName(), airport.getAddress()))
                .collect(Collectors.toList());
    }

    @Override
    public AirportResponse findAirportById(Long id) {
        return airportRepository.findById(id).map(airport -> new AirportResponse(airport.getCode(), airport.getName(), airport.getAddress())).get();
    }

    @Override
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }

    @Override
    public void updateAirport(Airport airport) {
        airportRepository.save(airport);
    }

    @Override
    public void updateAirport(Long id, String code, String name, Address address) {
        Airport airport = airportRepository.getOne(id);
        airport.setCode(code);
        airport.setName(name);
        airport.setAddress(address);

        updateAirport(airport);
    }

}
