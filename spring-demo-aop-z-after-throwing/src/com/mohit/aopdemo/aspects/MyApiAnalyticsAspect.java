package com.mohit.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

	@Before("com.mohit.aopdemo.aspects.LoveAopExpressions.forDatoPackageWithoutGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("========>>> Peform API Analytics");
	}
}
