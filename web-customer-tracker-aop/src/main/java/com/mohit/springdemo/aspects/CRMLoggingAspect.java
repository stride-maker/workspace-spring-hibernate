package com.mohit.springdemo.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private static Logger myLogger = Logger.getLogger(CRMLoggingAspect.class.getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.mohit.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.mohit.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.mohit.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add the before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display the method and display the arguments
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>>> @Before Advice: calling method: " + method);
		
		Object[] methodArgs = theJoinPoint.getArgs();
		for(Object arg : methodArgs) {
			
			myLogger.info("=====>>>> @Before Advice: argument: " + arg);
		}
	}
	
	// add the after returning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void afterReturning(JoinPoint theJoinPoint, Object result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>>> @AfterReturning Advice: from method: " + method);
		
		myLogger.info("=====>>>> @AfterReturning Advice: Result: " + result);
	}
}
