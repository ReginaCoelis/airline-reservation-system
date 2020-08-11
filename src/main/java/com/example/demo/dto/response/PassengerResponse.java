package com.example.demo.dto.response;

public class PassengerResponse {

    private AirlineResponse name;
    private AirlineResponse role;
    private AirlineResponse email;

    public PassengerResponse(){

    }

    public AirlineResponse getName() {
        return name;
    }

    public void setName(AirlineResponse name) {
        this.name = name;
    }

    public AirlineResponse getRole() {
        return role;
    }

    public void setRole(AirlineResponse role) {
        this.role = role;
    }

    public AirlineResponse getEmail() {
        return email;
    }

    public void setEmail(AirlineResponse email) {
        this.email = email;
    }
}
