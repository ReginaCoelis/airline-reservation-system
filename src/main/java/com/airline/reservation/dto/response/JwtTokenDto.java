package com.airline.reservation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JwtTokenDto {
    @JsonProperty("access_token")
    private String token;
    public JwtTokenDto(String token) {
        this.token = token;
    }
}
