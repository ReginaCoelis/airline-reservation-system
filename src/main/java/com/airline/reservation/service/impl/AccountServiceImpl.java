package com.airline.reservation.service.impl;

import com.airline.reservation.domain.Passenger;
import com.airline.reservation.exception.EmailExistsException;
import com.airline.reservation.repository.PassengerRepository;
import com.airline.reservation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private PassengerRepository passengerRepository;
    @Override
    public void createAccount(Passenger passenger) {
        Optional<Passenger> passengerOptional= passengerRepository.findByEmail(passenger.getEmail());
        passengerOptional.ifPresent(p ->{
            throw new EmailExistsException("Email has been taken by another user");
        });
        passengerRepository.save(passenger);
    }
}
