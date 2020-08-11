package com.airline.reservation.repository;

import com.airline.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    public Reservation findByReservationCode(String reservationCode);

    @Query(value = "SELECT r.id FROM Reservation r WHERE r.passengerId = ?1", nativeQuery=true)
    public Set<Integer> findFlightNumbers(Integer passengerId);

    @Query(value = "SELECT r.id FROM Reservation r WHERE r.passengerId = ?1", nativeQuery=true)
    public Integer findReservationIdByPassengerId(Integer passengerId);

//    @Query(value = "FROM Rese", nativeQuery=true)
//    public Integer findFlightNumberByReservationId(Integer reservationId);

}
