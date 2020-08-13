package com.airline.reservation.service.impl;

import com.airline.reservation.domain.Ticket;
import com.airline.reservation.dto.response.TicketResponse;
import com.airline.reservation.repository.TicketRepository;
import com.airline.reservation.service.FlightService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightServiceImplTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private FlightService flightService;
    @Autowired
    private TicketRepository ticketRepository;
   // @Test
    public void notifyUpcomingFlights() {
        List<String> emails = Arrays.asList("powusu@gmail.com");
        rabbitTemplate.convertAndSend("airline.emails.*",emails);
        assertTrue(true);
    }


    @Test
    public void shouldCallgetFlightByPassengerId(){
        assertThrows(NoSuchElementException.class,() -> flightService.getFlightByPassengerId(1));
        //assertThrows(NoSuchElementException.class, () -> Optional.ofNullable(ticketRepository.findByPassengerId((long)1)).orElseThrow());
    }
}