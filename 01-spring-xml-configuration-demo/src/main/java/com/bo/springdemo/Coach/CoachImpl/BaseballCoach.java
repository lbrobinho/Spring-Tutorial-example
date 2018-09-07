package com.bo.springdemo.Coach.CoachImpl;

import com.bo.springdemo.Coach.Coach;
import com.bo.springdemo.FortuneService.FortuneService;

public class BaseballCoach implements Coach {


    //define a dependecy field
    private FortuneService fortuneService;

    public BaseballCoach() {

    }

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }


    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }


}
