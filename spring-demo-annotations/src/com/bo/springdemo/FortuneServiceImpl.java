package com.bo.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService{

    @Override
    public String getDailyFortune() {
        return "Today is a good day";
    }
}
