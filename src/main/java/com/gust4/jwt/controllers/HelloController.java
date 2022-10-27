package com.gust4.jwt.controllers;

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
