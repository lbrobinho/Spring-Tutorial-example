package com.bo.springdemo.Coach;

import com.bo.springdemo.fortuneService.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class FootballCoach implements Coach{

    private FortuneService fortuneService;

    public FootballCoach() {

        System.out.println("This is a test1");
    }

    @Value("${foo.email}")

    private String email;

    @Value("${foo.team}")
    private String team;


    @Autowired
    @Qualifier("badFortuneService")
    public void setFortuneService(FortuneService fortuneService) {

        System.out.println("This is a test for Autowired");
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
