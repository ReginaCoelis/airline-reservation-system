package com.airline.reservation.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties("airline.reservation")
@Component
public class EnvironmentProperties {
    private Jwt jwt = new Jwt();
    @Data
    static class Jwt{
        private String issuer;
        private String secret;
        private Long expirationTime;
        private String tokenPrefix;
        private String headerString;
    }
}
