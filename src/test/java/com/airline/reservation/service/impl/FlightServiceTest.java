package com.airline.reservation.service.impl;

import com.airline.reservation.dto.request.FlightRequest;
import com.airline.reservation.dto.response.FlightResponse;
import com.airline.reservation.repository.TicketRepository;
import com.airline.reservation.service.FlightService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@WithMockUser(username = "usertest", password = "password", roles = "ADMIN")
@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan("com.airline.reservation.service")
public class FlightServiceTest {
    FlightResponse flightResponse;
    FlightResponse flightResponse1;

    @Autowired
    private FlightService flightService;
    @Autowired
    private TicketRepository ticketRepository;

    @Before
    public void setUp(){
        LocalDate date = LocalDate.of(2020, 1, 8);
        LocalDate date1 = LocalDate.of(2020, 1, 10);
        LocalTime localTime2 = LocalTime.of(21, 30, 59, 11001);

        FlightRequest request = new FlightRequest(7342, 300, "Cedar Rapids", localTime2, date, "Demoines", localTime2, date1, "XY234");
        flightService.addFlight(request);
    }

    @Test
    public void shouldCallgetFlightByPassengerId(){
        assertThrows(NoSuchElementException.class,() -> flightService.getFlightByPassengerId(1));
        //assertThrows(NoSuchElementException.class, () -> Optional.ofNullable(ticketRepository.findByPassengerId((long)1)).orElseThrow());
    }

    @Test
    public void findAll(){
        List<FlightResponse> flightResponses = flightService.getAllFlights();

        assertThat(flightResponses).hasSize(1);
    }
}
