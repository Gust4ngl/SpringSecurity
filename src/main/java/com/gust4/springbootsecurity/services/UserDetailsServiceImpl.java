package com.gust4.springbootsecurity.services;


import com.gust4.springbootsecurity.model.*;
import com.gust4.springbootsecurity.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;

public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.findByUsername(username);
        if (userInfo == null) throw new UsernameNotFoundException("User not found");
        return new UserDetailsImpl(userInfo);
    }
}
