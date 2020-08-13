package com.airline.reservation.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private final EnvironmentProperties environment;
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, EnvironmentProperties environment) {
        super(authenticationManager);
        this.environment = environment;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Gets the header from the request
        String header = request.getHeader("authorization");
        log.info("Header {}",header);

        // Validates header
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        // Verifies token again
        Optional<UsernamePasswordAuthenticationToken> authentication
                = getAuthentication(request);

        authentication.ifPresent(auth-> SecurityContextHolder.getContext().setAuthentication(auth));



        // Continue ...
        chain.doFilter(request, response);
    }

    /**
     *
     * @param request
     * @return
     */
    private Optional<UsernamePasswordAuthenticationToken> getAuthentication(HttpServletRequest request){
        Optional<String> token = Optional.ofNullable(request.getHeader("authorization"));
        // Token is checked
        if(token.isPresent()){
            // parse the token.
            String user = JWT.require(Algorithm.HMAC512(environment.getJwt().getSecret().getBytes()))
                    .build()
                    .verify(token.get().replace("Bearer ", ""))
                    .getSubject();


            if (user != null){
                List<GrantedAuthority> mapRolesToGrantedAuthorities =
                        getClaim(token.get().replace("Bearer ", "")).asList(String.class)
                                .stream()
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList());
                logger.info(mapRolesToGrantedAuthorities.get(0));
                return Optional.of(new UsernamePasswordAuthenticationToken(user,null,mapRolesToGrantedAuthorities));
            }
            return Optional.empty();

        }
        return Optional.empty();
    }

    /**
     * Method Decodes and retrieve user roles
     * @param token
     * @return
     */
    private Claim getClaim(String token){
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim("roles");
    }
}
