package com.advancedjava.LabSignIn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home"; // Name of the Thymeleaf template for the home page
    }
}
