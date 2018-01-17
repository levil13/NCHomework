package com.lux.netcracker.homework.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class GreetingController {
    @GetMapping("/")
    public String hello() throws IOException, InterruptedException {
        return "index";
    }
}
