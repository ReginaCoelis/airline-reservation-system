package com.example.demo.repository;

import com.example.demo.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    public Optional<Passenger> findByEmail(String email);
}
