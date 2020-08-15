package com.airline.reservation.dto.request;

public class AirlineRequest {

    private String code;
    private String name;
    private String history;

    public AirlineRequest(){}

    public AirlineRequest(String code, String name, String history) {
        this.code = code;
        this.name = name;
        this.history = history;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
