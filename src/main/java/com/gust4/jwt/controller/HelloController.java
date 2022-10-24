package com.gust4.jwt.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/adm")
    public String helloAdm() {
        return "hello adm";
    }

    @GetMapping("/user")
    public String helloUser() {
        return "hello User";
    }

}
