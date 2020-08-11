package com.airline.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.reservation.domain.Passenger;


import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    public Optional<Passenger> findByEmail(String email);

}
