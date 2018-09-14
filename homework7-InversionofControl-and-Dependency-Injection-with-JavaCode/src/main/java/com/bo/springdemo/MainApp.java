package com.bo.springdemo;

import com.bo.springdemo.coach.Coach;
import com.bo.springdemo.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        // get the bean from spring container
        Coach theCoach = context.getBean("wrestlingCoach", Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call a method on the bean
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
