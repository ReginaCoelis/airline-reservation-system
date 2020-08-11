package com.airline.reservation.repository;

import com.airline.reservation.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    public Airport findByCode(String airportCode);
}
