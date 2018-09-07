package com.bo.springdemo;

import com.bo.springdemo.Coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetAnnotationDemoApp {

    public static void main(String[] args) {

        // load configuration into context
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //ge the bean from the container
        Coach theCoach = context.getBean("footballCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        //close the context
        context.close();
    }
}
