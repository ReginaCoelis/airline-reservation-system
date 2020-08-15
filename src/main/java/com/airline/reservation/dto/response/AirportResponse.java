package com.airline.reservation.dto.response;

import com.airline.reservation.domain.Address;

public class AirportResponse {

    private String code;
    private String name;
    private Address address;

    public AirportResponse(){}

    public AirportResponse(String code, String name, Address address) {
        this.code = code;
        this.name = name;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
