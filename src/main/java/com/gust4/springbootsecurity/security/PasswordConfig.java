package com.gust4.springbootsecurity.security;

import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}