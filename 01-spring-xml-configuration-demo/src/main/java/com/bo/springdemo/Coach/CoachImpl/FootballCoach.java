package com.bo.springdemo.Coach.CoachImpl;

import com.bo.springdemo.Coach.Coach;
import com.bo.springdemo.FortuneService.FortuneService;
import com.bo.springdemo.FortuneService.RandomFortuneService;

public class FootballCoach implements Coach {

    //define a dependecy field
    private FortuneService fortuneService;

    public FootballCoach() {

    }

    public FootballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "I want to beat Barcelona!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //add an init method
    public void domyStartupStuff() {
        System.out.println("TrackCoach: inside method domyStartupStuff");
    }

    //add an destroy method
    public void domyCleanupStuff() {
        System.out.println("TrackCoach: inside method domyCleanupStuff");
    }
}
