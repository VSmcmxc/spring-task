package com.epam.springtask.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    @RequestMapping("/")
    public String welcome(){
        return "Welcome";
    }
}
