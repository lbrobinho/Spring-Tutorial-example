package com.bo.springdemo;

import com.bo.springdemo.Coach.Coach;
import com.bo.springdemo.Coach.CoachImpl.BaseballCoach;

/**
 * Hello world!
 *
 */
public class MyApp
{
    public static void main( String[] args )
    {

        //Create the object
        Coach theCoach = new BaseballCoach();

        //use the object
        System.out.println(theCoach.getDailyWorkout());
    }
}
