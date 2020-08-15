package com.airline.reservation;

import com.airline.reservation.domain.Passenger;
import com.airline.reservation.domain.Role;
import com.airline.reservation.dto.request.PassengerRequest;
import com.airline.reservation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.Collections;

@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableConfigurationProperties
@EnableSwagger2
@SpringBootApplication
@EnableScheduling
public class AirlineReservationSystemApplication {
    @Autowired
    private AccountService accountService;
    public static void main(String[] args) {
        SpringApplication.run(AirlineReservationSystemApplication.class, args);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
