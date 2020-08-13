package com.airline.reservation.service.impl;

import com.airline.reservation.domain.Passenger;
import com.airline.reservation.domain.Role;
import com.airline.reservation.dto.request.PassengerRequest;
import com.airline.reservation.exception.EmailExistsException;
import com.airline.reservation.repository.PassengerRepository;
import com.airline.reservation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createAdmin(Passenger passenger){
        passenger.setPassword(passwordEncoder.encode(passenger.getPassword()));
        passengerRepository.save(passenger);
    }

    @Override
    public void createAccount(PassengerRequest passengerRequest) {
        Optional<Passenger> passengerOptional= passengerRepository.findByEmail(passengerRequest.getEmail());
        passengerOptional.ifPresent(p ->{
            throw new EmailExistsException("Email has been taken by another user");
        });
        Passenger passenger = new Passenger();
        passenger.setEmail(passengerRequest.getEmail());
        passenger.setName(passengerRequest.getName());
        passenger.setPassword(passwordEncoder.encode(passengerRequest.getPassword()));
        passenger.setRoles(Collections.singletonList(new Role("ROLE_PASSENGER")));
        passengerRepository.save(passenger);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Passenger> passengerOptional = passengerRepository.findByEmail(email);
        return passengerOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
