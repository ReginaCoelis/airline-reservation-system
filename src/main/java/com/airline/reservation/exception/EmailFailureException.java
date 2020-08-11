package com.airline.reservation.exception;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.PushBuilder;

@Slf4j
public class EmailFailureException extends RuntimeException {
    public EmailFailureException(String message) {
        System.out.println(message);
    }

}
