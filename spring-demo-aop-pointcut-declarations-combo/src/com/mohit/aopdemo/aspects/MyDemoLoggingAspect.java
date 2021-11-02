package com.mohit.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.mohit.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.mohit.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.mohit.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDatoPackageWithoutGetterAndSetter() {}
	
	
	@Before("forDatoPackageWithoutGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n\n========>>> Executing @Before Advice on method");
	}
	
	@Before("forDatoPackageWithoutGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("========>>> Peform API Analytics");
	}
}
