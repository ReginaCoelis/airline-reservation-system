package com.airline.reservation.dto.request;

import lombok.Data;

@Data
public class BookingRequest {
    private Long passengerId;
    private Long flightId;
}
