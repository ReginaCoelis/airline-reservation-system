package com.airline.reservation.dto.response;

public class AirlineResponse {

    private AirportResponse code;
    private AirportResponse name;
    private AirportResponse history;

    public AirlineResponse(){}

    public AirportResponse getCode() {
        return code;
    }

    public void setCode(AirportResponse code) {
        this.code = code;
    }

    public AirportResponse getName() {
        return name;
    }

    public void setName(AirportResponse name) {
        this.name = name;
    }

    public AirportResponse getHistory() {
        return history;
    }

    public void setHistory(AirportResponse history) {
        this.history = history;
    }
}
