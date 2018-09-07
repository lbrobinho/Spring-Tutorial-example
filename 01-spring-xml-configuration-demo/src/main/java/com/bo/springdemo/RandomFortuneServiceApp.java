package com.bo.springdemo;

import com.bo.springdemo.Coach.CoachImpl.FootballCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RandomFortuneServiceApp {

    public static void main(String[] args) {

        //load the configure file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean
        FootballCoach footballCoach = context.getBean("FootballCoach", FootballCoach.class);

        System.out.println(footballCoach.getDailyFortune());
        System.out.println(footballCoach.getDailyWorkout());

        //close the context
        context.close();
    }

}
