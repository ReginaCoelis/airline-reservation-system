package com.airline.reservation;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AirlineReservationSystemApplication {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public static void main(String[] args) {
        SpringApplication.run(AirlineReservationSystemApplication.class, args);
    }

}
