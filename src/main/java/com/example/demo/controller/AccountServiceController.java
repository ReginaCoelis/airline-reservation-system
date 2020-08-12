package com.example.demo.controller;


import com.example.demo.domain.Passenger;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountServiceController {
    @Autowired
    public AccountService accountService;

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Account created successfully!")
    public void createAccount(@RequestBody Passenger passenger ){
        accountService.createAccount(passenger);

    }


}
