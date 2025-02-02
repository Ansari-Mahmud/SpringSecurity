package com.mahmud.InventorySystem.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class GreetingController {
    LocalTime currentTime = LocalTime.now();
    int hour = currentTime.getHour();
    String greeting="";

    @RequestMapping("/")
    public String greeting() {
        if (hour >= 5 && hour < 12) {
            greeting = "Good Morning!";
        } else if (hour >= 12 && hour < 17) {
            greeting = "Good Afternoon!";
        } else if (hour >= 17 && hour < 21) {
            greeting = "Good Evening!";
        } else {
            greeting = "Good Night!";
        }
        return greeting;
    }
    @RequestMapping("/whoami")
    public String whoami() {
        String name = greeting()+" Welcome to Inventory System";
        return name;
    }
    @PreAuthorize("hasRole('seller')")
    @GetMapping("/seller")
    public String seller() {
        return "Hi Seller, How are you doing today?";
    }
    @GetMapping("/user")
    public String user() {
        return "Hi User, How are you doing today?";
    }
}
