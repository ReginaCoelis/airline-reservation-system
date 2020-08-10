package com.example.demo.repository;

import com.example.demo.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    public Airport findByCode(String airportCode);
}
