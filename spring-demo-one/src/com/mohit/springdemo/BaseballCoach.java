package com.mohit.springdemo;

public class BaseballCoach implements Coach {
	
	// define a private field for the dependency 
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortune service to give the fortune
		return fortuneService.getFortune();
	}
	
}
