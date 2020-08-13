package com.airline.reservation.dto.request;

import lombok.Data;

@Data
public class PassengerRequest {
    private String password;
    private String name;
    private String email;
}
