package com.bo.springdemo.Coach;

import com.bo.springdemo.fortuneService.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="prototype")
public class CrazyFootballCoach implements Coach {

    private FortuneService fortuneService;

    @Autowired
    @Lazy
    @Qualifier("happyFortuneService")
    public void doSomeCrazyStuff(FortuneService fortuneService) {

        System.out.println("inside doSomeCrazyStuff() method");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Train like Ronaldo!!!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
