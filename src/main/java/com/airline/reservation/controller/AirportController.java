package com.airline.reservation.controller;

import com.airline.reservation.domain.Address;
import com.airline.reservation.dto.request.AirportRequest;
import com.airline.reservation.dto.response.AirportResponse;
import com.airline.reservation.service.AirportService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/airports")
@Api(description = "Airport Controller handles all endpoints related to airport CRUD operations")
public class AirportController {

    @Autowired
    AirportService airportService;

    @PostMapping("/saveAirport")
    public void saveAirport(@RequestBody AirportRequest airportRequest){
        airportService.addAirport(airportRequest);
    }

    @GetMapping("/getAllAirports")
    public List<AirportResponse> getAllAirports(){
        return airportService.getAllAirports();
    }

    @GetMapping("/getAirportById/{id}")
    public AirportResponse getAllAirports(@PathVariable Long id){
        return airportService.findAirportById(id);
    }

    @DeleteMapping(value = "/deleteAirportById/{id}")
    public void deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
    }

    @PutMapping(value = "updateAirport/{id}")
    public void updateAirport(@PathVariable Long id, String code, String name, Address address) {
        airportService.updateAirport(id, code, name, address);
    }
}
