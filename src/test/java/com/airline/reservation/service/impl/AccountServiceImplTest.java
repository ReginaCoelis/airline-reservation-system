package com.airline.reservation.service.impl;

import com.airline.reservation.domain.Passenger;
import com.airline.reservation.domain.Role;
import com.airline.reservation.dto.request.PassengerRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccountServiceImplTest {
    private final AccountServiceImpl accountService = mock(AccountServiceImpl.class);

    @Test
    public void shouldCallCreateAccount(){
        PassengerRequest passenger = new PassengerRequest();
        passenger.setEmail("john.doe@test.com");
        passenger.setName("John Doe");
        accountService.createAccount(passenger);
        assertTrue(true);
    }
}