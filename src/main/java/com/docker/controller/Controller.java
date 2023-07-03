package com.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String getMessage(){
        return "Hello, This is your First Dockerized SpringBoot Application";
    }
    @GetMapping("/Abhi")
    public String getGreeting(){
        return "Namaskar Abhishek Malak";
    }
}

