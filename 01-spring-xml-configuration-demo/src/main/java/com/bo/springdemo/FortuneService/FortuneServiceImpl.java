package com.bo.springdemo.FortuneService;

public class FortuneServiceImpl implements FortuneService{

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
