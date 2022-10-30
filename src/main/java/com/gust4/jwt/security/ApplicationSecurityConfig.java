package com.gust4.jwt.security;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.provisioning.*;
import org.springframework.security.web.csrf.*;

import static com.gust4.jwt.security.ApplicationUserPermission.*;
import static com.gust4.jwt.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeRequests()
                .antMatchers("/" ,"index" , "/hello/user").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
       UserDetails gustaUser = User.builder()
               .username("Gusta")
               .password(passwordEncoder.encode("password"))
//               .roles(ADMIN.name())
               .authorities(ADMIN.getGrandGrantedAuthorities())
               .build();

       UserDetails testUser = User.builder()
               .username("gusta2")
               .password(passwordEncoder.encode("password"))
//               .roles(STUDENT.name())
               .authorities(STUDENT.getGrandGrantedAuthorities())
               .build();

       UserDetails traineeUser = User.builder()
               .username("gusta3")
               .password(passwordEncoder.encode("password"))
//               .roles(ADMINTRAINEE.name())
               .authorities(ADMINTRAINEE.getGrandGrantedAuthorities())
               .build();

       return new InMemoryUserDetailsManager(
               gustaUser,
               testUser,
               traineeUser
       );

    }
}
