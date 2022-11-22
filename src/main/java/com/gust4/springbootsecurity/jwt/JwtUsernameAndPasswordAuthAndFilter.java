package com.gust4.springbootsecurity.jwt;

import com.fasterxml.jackson.databind.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.web.authentication.*;

import javax.servlet.http.*;
import java.io.*;

public class JwtUsernameAndPasswordAuthAndFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public JwtUsernameAndPasswordAuthAndFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            UsernameAndPasswordAuthRequest authenticationRequest = new ObjectMapper().
                    readValue(request.getInputStream(), UsernameAndPasswordAuthRequest.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.attemptAuthentication(request, response);
    }
}
