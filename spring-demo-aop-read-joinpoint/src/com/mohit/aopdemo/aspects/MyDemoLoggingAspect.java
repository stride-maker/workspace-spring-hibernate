package com.mohit.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mohit.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.mohit.aopdemo.aspects.LoveAopExpressions.forDatoPackageWithoutGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("========>>> Executing @Before Advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		// display the method arguments
		Object[] methodArgs = theJoinPoint.getArgs();
		for(Object arg: methodArgs) {
			System.out.println("Method arg: " + arg);
			
			if(arg instanceof Account) {
				Account theAccount = (Account) arg;
				System.out.println("Account Name: " + theAccount.getName());
				System.out.println("Level: " + theAccount.getLevel());
			}
		}
	}
	
}
