package com.airline.reservation.dto.response;

public class AirlineResponse {

    private Long id;
    private String code;
    private String name;
    private String history;

    public AirlineResponse(){}

    public AirlineResponse(Long id, String code, String name, String history) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.history = history;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
