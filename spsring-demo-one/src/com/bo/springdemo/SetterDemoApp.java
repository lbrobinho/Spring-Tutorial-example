package com.bo.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

    public static void main(String[] args) {

        //load the spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean from the container
        FootballCoach myFootballCoach = context.getBean("myFootballCoach", FootballCoach.class);

        //call methods on the bean
        System.out.println( myFootballCoach.getDailyWorkout());
        System.out.println( myFootballCoach.getDailyFortune());
        System.out.println( (myFootballCoach).getEmailAddress());
        System.out.println( (myFootballCoach).getTeam());


        //close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
