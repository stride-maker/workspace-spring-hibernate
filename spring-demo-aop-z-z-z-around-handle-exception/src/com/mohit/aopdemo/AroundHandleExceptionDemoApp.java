package com.mohit.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mohit.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\n\nMain Program: AroundDemoApp");
		myLogger.info("\nCalling getFortune()");
		
		boolean tripWire = true;
		String data = trafficFortuneService.getFortunes(tripWire);
		
		myLogger.info("\nMy Fortune is: " + data);
		myLogger.info("\nFinished");
		context.close();

	}

}
