package com.airline.reservation.repository;

import com.airline.reservation.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    public Flight getByFlightNumber(Integer flightNumber);

}
