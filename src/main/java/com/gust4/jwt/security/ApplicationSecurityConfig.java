package com.gust4.jwt.security;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.provisioning.*;

import static com.gust4.jwt.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/" ,"index" , "/hello/user").permitAll()
                .antMatchers("/hello/trainee").hasRole(ADMINTRAINEE.name())
                .antMatchers("/hello/*").hasRole(ADMIN.name())
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
       UserDetails gustaUser = User.builder()
               .username("Gusta")
               .password(passwordEncoder.encode("password"))
               .roles(ADMIN.name())
               .build();

       UserDetails testUser = User.builder()
               .username("gusta2")
               .password(passwordEncoder.encode("password"))
               .roles(STUDENT.name())
               .build();

       UserDetails traineeUser = User.builder()
               .username("gusta3")
               .password(passwordEncoder.encode("password"))
               .roles(ADMINTRAINEE.name())
               .build();

       return new InMemoryUserDetailsManager(
               gustaUser,
               testUser,
               traineeUser
       );

    }
}
