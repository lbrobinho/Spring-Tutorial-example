package com.bo.springdemo.fortuneService;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BadFortuneService implements FortuneService {

    @Override
    public String getFortune() {

        return "Today is a bad day!";
    }
}
