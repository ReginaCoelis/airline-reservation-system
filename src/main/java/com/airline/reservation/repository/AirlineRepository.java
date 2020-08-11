package com.airline.reservation.repository;

import com.airline.reservation.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    Airline findByName(String name);

    Airline findByCode(String airlineCode);

//    List<Airline> getAllAirlinesOutOfAnAirport(String airportCode);

}
