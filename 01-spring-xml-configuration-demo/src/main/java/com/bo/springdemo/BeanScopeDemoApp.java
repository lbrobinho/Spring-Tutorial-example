package com.bo.springdemo;

import com.bo.springdemo.Coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        //retrieve bean from spring container
        Coach BaseballCoach = context.getBean("BaseballCoach", Coach.class);

        Coach BaseballCoach2 = context.getBean("BaseballCoach", Coach.class);

        //check if they are same bean
        boolean result = (BaseballCoach == BaseballCoach2);

        System.out.println("\nPointing to the same object: " + result);

        System.out.println("\nMemory location for theCoach: " + BaseballCoach);

        System.out.println("\nMemory location for BaseballCoach2 : " + BaseballCoach2);


        //close the context
        context.close();
    }
}
