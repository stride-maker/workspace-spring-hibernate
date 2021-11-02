package com.mohit.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	@Before("com.mohit.aopdemo.aspects.LoveAopExpressions.forDatoPackageWithoutGetterAndSetter()")
	public void logToCloudAsync() {
		System.out.println("\n\n========>>> Logging to cloud in async fashion");
	}
}
