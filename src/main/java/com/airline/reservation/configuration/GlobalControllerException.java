package com.airline.reservation.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class GlobalControllerException {

    @ExceptionHandler({NoSuchElementException.class,NullPointerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Throwable throwable){
         if(throwable instanceof NoSuchElementException){
             return ResponseEntity.notFound().build();
         }
         log.info("Error {}",throwable.getStackTrace());
        return new ResponseEntity("An Error Occured. Please try again later",HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
