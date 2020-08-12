package com.airline.reservation.controller;


import com.airline.reservation.domain.Passenger;
import com.airline.reservation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    public AccountService accountService;

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Account created successfully!")
    public void createAccount(@RequestBody Passenger passenger ){
        accountService.createAccount(passenger);

    }


}
