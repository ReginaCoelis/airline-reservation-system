package com.airline.reservation.service;

import com.airline.reservation.domain.Airport;
import com.airline.reservation.domain.Address;
import com.airline.reservation.dto.request.AirportRequest;
import com.airline.reservation.dto.response.AirportResponse;

import java.util.List;

public interface AirportService {
    public void addAirport(AirportRequest requestAirport);

    public List<AirportResponse> getAllAirports();

    public AirportResponse findAirportById(Long id);

    public void deleteAirport(Long id);

    public void updateAirport(Airport airport);

    public void updateAirport(Long id, String code, String name, Address address);
}
