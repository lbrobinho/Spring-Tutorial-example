package com.bo.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("restFortuneService")
    private  FortuneService fortuneService;

    //define a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }
    /*
    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    */

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    /*
    //define a setter method
    @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println(">> TennisCoach: inside doSomeCrazyStuff method");
    }
    */

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }


}
