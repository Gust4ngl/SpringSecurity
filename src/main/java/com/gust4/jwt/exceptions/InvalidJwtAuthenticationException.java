package com.gust4.jwt.exceptions;

import org.springframework.http.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJwtAuthenticationException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public InvalidJwtAuthenticationException(String ex) {
        super(ex);
    }
}