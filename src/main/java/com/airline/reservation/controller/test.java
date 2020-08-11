package com.airline.reservation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping("/")
    public String getId(){
      return "Hello There";
    }

    @PostMapping("/")
    public void save(){}
}
