package com.gust4.jwt.controllers;

import org.springframework.security.access.prepost.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/user")
    public String user() {return "hello user";}

    @GetMapping("/adm")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adm() {return "hello adm";}

    @GetMapping("/trainee")
    @PreAuthorize("hasAnyRole('ROLE_ADMINTRAINEE', 'ROLE_ADMIN' )")
    public String admTrainee() {return "hello trainee";}

}
