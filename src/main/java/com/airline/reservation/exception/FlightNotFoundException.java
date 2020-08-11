package com.airline.reservation.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlightNotFoundException extends RuntimeException {

    public FlightNotFoundException(String message) {
        System.out.println(message);
    }
}
