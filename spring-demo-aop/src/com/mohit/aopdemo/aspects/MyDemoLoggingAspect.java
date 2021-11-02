package com.mohit.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is an aspect -- we add all of our related advices
	
	// lets start with the before advice
	
//	@Before("execution(public void add*())")
//	@Before("execution(* add*(com.mohit.aopdemo.Account))")
//	@Before("execution(* add*(com.mohit.aopdemo.Account, ..))")
	@Before("execution(* com.mohit.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n\n========>>> Executing @Before Advice on method");
	}
}
