package com.airline.reservation.service;


import com.airline.reservation.domain.Passenger;
import com.airline.reservation.dto.request.PassengerRequest;


public interface AccountService {
    public void createAccount(PassengerRequest passenger);
    public void createAdmin(Passenger passenger);
}
