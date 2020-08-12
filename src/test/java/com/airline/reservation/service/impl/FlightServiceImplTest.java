package com.airline.reservation.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightServiceImplTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void notifyUpcomingFlights() {
        List<String> emails = Arrays.asList("powusu@gmail.com");
        rabbitTemplate.convertAndSend("airline.emails.*",emails);
        assertTrue(true);
    }
}