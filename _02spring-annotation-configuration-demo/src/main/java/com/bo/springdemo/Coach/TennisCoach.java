package com.bo.springdemo.Coach;

import com.bo.springdemo.fortuneService.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    @Autowired
    @Lazy
    public TennisCoach(@Qualifier("randomFortuneService")
                                   FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice every day!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
