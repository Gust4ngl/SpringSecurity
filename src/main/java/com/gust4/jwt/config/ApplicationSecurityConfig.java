package com.gust4.jwt.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/hello/user").permitAll()
                .antMatchers("/hello/adm").authenticated()
                .and()
                .httpBasic();
    }
}
