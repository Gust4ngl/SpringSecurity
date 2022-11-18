package com.gust4.springbootsecurity.repositories;


import com.gust4.springbootsecurity.model.*;
import com.gust4.springbootsecurity.services.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
}
