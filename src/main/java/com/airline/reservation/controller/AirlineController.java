package com.airline.reservation.controller;

import com.airline.reservation.dto.request.AirlineRequest;
import com.airline.reservation.dto.response.AirlineResponse;
import com.airline.reservation.service.AirlineService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "Airline Controller handles all end points responsible for Airline CRUD operations")
@RequestMapping("/airlines")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @PostMapping("/saveAirline")
    public void saveAirline(@RequestBody AirlineRequest airlineRequest){
        airlineService.saveAirline(airlineRequest);
    }

    @GetMapping("/getAirlineById/{id}")
    public AirlineResponse getAirlineById(@PathVariable Long id){
        return airlineService.getAirlineById(id);
    }

    @GetMapping(value = "/getAirlineByName/{name}", params = {"name"})
    public AirlineResponse getAirlineByName(@RequestParam String name){
        return airlineService.getAirlineByName(name);
    }

    @GetMapping("/getAllAirlines")
    public List<AirlineResponse> getAirlineById(){
        return airlineService.getAllAirlines();
    }

    @DeleteMapping("/deleteAirlineById/{id}")
    public void deleteAirlineById(@PathVariable Long id){
        airlineService.deleteAirline(id);
    }

    @DeleteMapping
    public void deleteAllAirlines(){
        airlineService.deleteAll();
    }

    @PutMapping("/updateAirlineInfo/{id}")
    public void updateAirline(@PathVariable Long id, String code, String name){
        airlineService.updateAirline(id, code, name);
    }

    @GetMapping(name = "/getAirlineByAirportCode",params = {"airlineCode"})
    public List<AirlineResponse> getAirlineByAirportCode(@RequestParam String airlineCode){
        return airlineService.getAirlineByAirportCode(airlineCode);
    }

}
