package com.gust4.springbootsecurity.services;

import com.gust4.springbootsecurity.model.*;
import com.gust4.springbootsecurity.model.User;
import com.gust4.springbootsecurity.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User not found!");
        return new CustomUserDetails(user);
    }
}
