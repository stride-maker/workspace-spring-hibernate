package com.mohit.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mohit.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\n\n Main Program: AroundDemoApp");
		System.out.println("Calling getFortune()");
		
		String data = trafficFortuneService.getFortune();
		
		System.out.println("\nMy Fortune is: " + data);
		context.close();

	}

}
