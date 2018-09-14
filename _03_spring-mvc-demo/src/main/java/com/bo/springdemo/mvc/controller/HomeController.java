package com.bo.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String showPage() {

        System.out.println("This is a test");

        return "main-menu";
    }

}
