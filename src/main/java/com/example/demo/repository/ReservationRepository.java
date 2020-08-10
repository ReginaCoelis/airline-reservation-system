package com.example.demo.repository;

import com.example.demo.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    public Reservation findByReservationCode(String reservationCode);

    public List<Reservation> findByPassengerId(Long passengerId);

}
