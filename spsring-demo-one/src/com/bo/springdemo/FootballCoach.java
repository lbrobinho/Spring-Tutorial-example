package com.bo.springdemo;

public class FootballCoach implements Coach{

    private FortuneService fortuneService;

    //add new field for emailAddress and team
    private String emailAddress;
    private String team;

    public FootballCoach() {
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println("CricketCoach: inside no-arg setter");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach: inside setter method: setEmailAddress");
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter method: setTeam");
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Ronaldo is best player";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
