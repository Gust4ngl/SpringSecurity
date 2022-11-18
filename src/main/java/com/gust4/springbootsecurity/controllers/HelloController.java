package com.gust4.springbootsecurity.controllers;

import org.springframework.security.access.prepost.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/user")
    public String user() {return "hello user";}

    @GetMapping("/adm")
    public String adm() {return "hello adm";}

    @GetMapping("/trainee")
    public String admTrainee() {return "hello trainee";}

}
