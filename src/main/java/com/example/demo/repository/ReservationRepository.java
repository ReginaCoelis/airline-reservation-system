package com.example.demo.repository;

import com.example.demo.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    public Reservation findByReservationCode(String reservationCode);

    @Query("SELECT flightNumbers FROM Reservation WHERE passengerId = ?1")
    public Set<Integer> findFlightNumbers(Integer passengerId);

}
