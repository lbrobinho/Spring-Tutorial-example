package com.bo.springdemo.fortuneService;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is a random day!";
    }
}
