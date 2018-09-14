package com.bo.springdemo.Coach;

import com.bo.springdemo.fortuneService.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
public class BeanLifeCycleCoach implements Coach{

    @Autowired
    @Lazy
    @Qualifier("badFortuneService")
    private FortuneService fortuneService;


    @Override
    public String getDailyWorkout() {
        return "This is a bean life cycleCoach";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //add an init method
    @PostConstruct
    public void domyStartupStuff() {
        System.out.println("BeanLifeCycle: inside method domyStartupStuff");
    }

    //add an destroy method
    @PreDestroy
    public void domyCleanupStuff() {
        System.out.println("BeanLifeCycle: inside method domyCleanupStuff");
    }
}
