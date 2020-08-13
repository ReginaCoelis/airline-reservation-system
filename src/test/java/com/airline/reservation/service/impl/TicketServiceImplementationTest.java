package com.airline.reservation.service.impl;

import com.airline.reservation.repository.TicketRepository;
import com.airline.reservation.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketServiceImplementationTest {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    public void callGetTicketByPassengerId(){
       // assertThrows(NullPointerException.class,() -> ticketService.getTicketByPassengerId(1L));
        assertNull(ticketRepository.findByPassengerId(1L));
    }
}