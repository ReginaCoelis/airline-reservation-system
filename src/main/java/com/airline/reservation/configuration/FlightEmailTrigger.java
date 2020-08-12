package com.airline.reservation.configuration;

import com.airline.reservation.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;


@Slf4j
@Component
public class FlightEmailTrigger {
    @Autowired
    private FlightService flightService;

    // Trigger every hour
    @Scheduled(cron = "0 0 * ? * *")
    public void performTask() throws ExecutionException, InterruptedException {
        flightService.notifyUpcomingFlights();
    }
}
