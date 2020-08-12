package com.airline.reservation.service.impl;

import com.airline.reservation.domain.Passenger;
import com.airline.reservation.exception.EmailExistsException;
import com.airline.reservation.repository.PassengerRepository;
import com.airline.reservation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Secured({"ROLE_PASSENGER"})
    @Override
    public void createAccount(Passenger passenger) {
        Optional<Passenger> passengerOptional= passengerRepository.findByEmail(passenger.getEmail());
        passengerOptional.ifPresent(p ->{
            throw new EmailExistsException("Email has been taken by another user");
        });
        passenger.setPassword(passwordEncoder.encode(passenger.getPassword()));
        passengerRepository.save(passenger);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Passenger> passengerOptional = passengerRepository.findByEmail(email);
        return passengerOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
