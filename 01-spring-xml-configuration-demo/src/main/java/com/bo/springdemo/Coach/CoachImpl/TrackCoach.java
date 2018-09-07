package com.bo.springdemo.Coach.CoachImpl;

import com.bo.springdemo.Coach.Coach;
import com.bo.springdemo.FortuneService.FortuneService;

public class TrackCoach implements Coach {

    //define a dependecy field
    private FortuneService fortuneService;

    public TrackCoach() {

    }

    public TrackCoach(FortuneService fortuneService ) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "RUn a hard 5K";
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
