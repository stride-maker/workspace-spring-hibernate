package com.mohit.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	@Autowired // field injection (internally uses java reflection)
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println("Tennis Coach: inside default constructor");
	}
	
	// constructor injection
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	// setter injection 
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println("Tennis Coach: inside setFortuneService method");
//		this.fortuneService = fortuneService;
//	}
	
	// method injection
//	@Autowired
//	public void doCrazyStuff(FortuneService fortuneService) {
//		System.out.println("Tennis Coach: inside doCrazyStuff method");
//		this.fortuneService = fortuneService;
//	}
	
	
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("Tennis Coach: inside my doMyStartupStuff method");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("Tennis Coac: inside my doMyCleanupStuff method");
	}
	
	
	
	@Override
	public String getDailyWorkout() {
		return "Practive your backend volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
