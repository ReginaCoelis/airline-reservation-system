package com.airline.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AirlineReservationSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(AirlineReservationSystemApplication.class, args);
    }
}
