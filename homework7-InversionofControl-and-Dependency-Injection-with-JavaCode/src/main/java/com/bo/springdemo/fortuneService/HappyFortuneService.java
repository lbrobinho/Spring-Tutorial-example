package com.bo.springdemo.fortuneService;

public class HappyFortuneService implements FortuneService {


	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}
}
