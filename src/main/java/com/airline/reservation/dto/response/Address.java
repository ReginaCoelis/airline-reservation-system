package com.airline.reservation.dto.response;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private AirlineResponse street;
    private AirlineResponse city;
    private AirlineResponse state;
    private AirlineResponse zip;

    public AirlineResponse getStreet() {
        return street;
    }

    public void setStreet(AirlineResponse street) {
        this.street = street;
    }

    public AirlineResponse getCity() {
        return city;
    }

    public void setCity(AirlineResponse city) {
        this.city = city;
    }

    public AirlineResponse getState() {
        return state;
    }

    public void setState(AirlineResponse state) {
        this.state = state;
    }

    public AirlineResponse getZip() {
        return zip;
    }

    public void setZip(AirlineResponse zip) {
        this.zip = zip;
    }
}
