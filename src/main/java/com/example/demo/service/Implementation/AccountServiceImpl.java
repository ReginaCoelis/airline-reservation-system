package com.example.demo.service.Implementation;

import com.example.demo.domain.Passenger;
import com.example.demo.exception.EmailExistsException;
import com.example.demo.repository.PassengerRepository;
import com.example.demo.service.AccountService;
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
