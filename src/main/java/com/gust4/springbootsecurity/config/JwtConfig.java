package com.gust4.springbootsecurity.config;

import com.google.common.net.*;
import org.springframework.boot.context.properties.*;
import org.springframework.context.annotation.*;

@ConfigurationProperties(prefix = "security.jwt.token")
@Configuration
public class JwtConfig {

    private String secretKey;
    private String tokenPrefix;
    private Long tokenExpirationAfterDays;


    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public Long getTokenExpirationAfterDays() {
        return tokenExpirationAfterDays;
    }

    public void setTokenExpirationAfterDays(Long tokenExpirationAfterDays) {
        this.tokenExpirationAfterDays = tokenExpirationAfterDays;
    }

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}
