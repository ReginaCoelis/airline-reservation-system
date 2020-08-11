package com.airline.reservation.service.impl;

import com.airline.reservation.domain.Passenger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccountServiceImplTest {
    private final AccountServiceImpl accountService = mock(AccountServiceImpl.class);

    @Test
    public void shouldCallCreateAccount(){
        Passenger passenger = new Passenger();
        passenger.setEmail("john.doe@test.com");
        passenger.setName("John Doe");
        passenger.setRole("ROLE_PASSENGER");
        accountService.createAccount(passenger);
        assertTrue(true);
    }
}