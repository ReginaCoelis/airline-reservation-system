package com.airline.reservation.service.impl;

import com.airline.reservation.dto.request.FlightRequest;
import com.airline.reservation.dto.response.FlightResponse;
import com.airline.reservation.service.FlightService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan("com.airline.reservation.service")
public class FlightTest {
    FlightResponse flightResponse;
    FlightResponse flightResponse1;

    @Autowired
    FlightService flightService;

    @Before
    public void setUp(){
        DateFormat dateFormat = new SimpleDateFormat();
        String d1 = "22-01-2015 10:15:55";
        String d2 = "24-01-2015 11:45:55";

        Date date = null;
        Date date1 = null;

        try {
            date = dateFormat.parse(d1);
            date1 = dateFormat.parse(d2);
        }catch (ParseException e){
            e.printStackTrace();
        }
        FlightRequest request = new FlightRequest(7342, 300, "Cedar Rapids", date, date, "Demoines", date1, date1, "XY234");
        flightService.addFlight(request);
    }

    @Test
    public void findAll(){
        List<FlightResponse> flightResponses = flightService.getAllFlights();

        assertThat(flightResponses).hasSize(1);
    }
}
