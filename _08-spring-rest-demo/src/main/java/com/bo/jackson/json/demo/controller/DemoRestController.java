package com.bo.jackson.json.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class DemoRestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World! ";
    }
}
