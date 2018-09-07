package com.bo.springdemo;

import com.bo.springdemo.Coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from spring container
        Coach BaseballCoach = context.getBean("BaseballCoach", Coach.class);
        Coach TrackCoach = context.getBean("TrackCoach", Coach.class);


        //call methods on the bean
        System.out.println(BaseballCoach.getDailyWorkout());
        System.out.println(BaseballCoach.getDailyFortune());
        System.out.println(TrackCoach.getDailyWorkout());
        System.out.println(TrackCoach.getDailyFortune());

        //close the context
        context.close();
    }
}
