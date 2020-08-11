package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String message){
        log.info("Email: {}",message);
    }
}
