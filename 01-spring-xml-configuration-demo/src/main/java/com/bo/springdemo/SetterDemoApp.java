package com.bo.springdemo;

import com.bo.springdemo.Coach.Coach;
import com.bo.springdemo.Coach.CoachImpl.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from spring container
        Coach CricketCoach = context.getBean("CricketCoach", CricketCoach.class);



        //call methods on the bean
        System.out.println(CricketCoach.getDailyWorkout());
        System.out.println(CricketCoach.getDailyFortune());

        System.out.println(((CricketCoach) CricketCoach).getEmailAddress());
        System.out.println(((CricketCoach) CricketCoach).getTeam());
        //close the context
        context.close();
    }
}
