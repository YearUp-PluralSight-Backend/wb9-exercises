package com.pluralsight.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {


    @GetMapping("/welcome")
    public String welcome(@RequestParam(defaultValue="World") String country) {
        return "Welcome to " + country;
    }
}
