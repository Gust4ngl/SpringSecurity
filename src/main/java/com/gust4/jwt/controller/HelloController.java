package com.gust4.jwt.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/user")
    public String helloUser() {
        return "Hello user";
    }

    @GetMapping("/admin")
    public String helloADM() {
        return "Hello admin";
    }

}
