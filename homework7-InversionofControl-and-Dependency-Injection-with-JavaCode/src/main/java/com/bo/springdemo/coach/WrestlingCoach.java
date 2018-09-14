package com.bo.springdemo.coach;

import com.bo.springdemo.fortuneService.FortuneService;

public class WrestlingCoach implements Coach {

    private FortuneService fortuneService;

    public WrestlingCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Today you have done many tuff";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
