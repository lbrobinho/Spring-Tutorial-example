package com.bo.springdemo.FortuneService;

import java.util.Random;

public class RandomFortuneService implements FortuneService{

    private String[] array = {"Beware of the wolf in sheep's clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"};

    //create a random number generator
    private Random myRandom = new Random();


    @Override
    public String getFortune() {

        int index = myRandom.nextInt(array.length);

        return array[index];
    }
}
