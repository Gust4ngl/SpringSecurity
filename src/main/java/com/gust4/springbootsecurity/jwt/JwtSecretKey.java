package com.gust4.springbootsecurity.jwt;

import com.gust4.springbootsecurity.config.*;
import io.jsonwebtoken.security.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

import javax.crypto.*;

@Configuration
public class JwtSecretKey {
    private final JwtConfig jwtConfig;

    @Autowired
    public JwtSecretKey(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Bean
    public SecretKey getSecretKeyForSignin() {
        return Keys.hmacShaKeyFor(jwtConfig.getSecretKey().getBytes());
    }
}
