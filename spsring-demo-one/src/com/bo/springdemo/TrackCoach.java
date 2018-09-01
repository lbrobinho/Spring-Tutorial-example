package com.bo.springdemo;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    public TrackCoach() {

    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "RUn a hard 5K";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }

    //add an init method
    public void doMyStartupStuff() {
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    //add an destroy method
    public void doMyCleanupStuff() {
        System.out.println("TrackCoach: inside method doMyCleanupStuff");
    }
}
