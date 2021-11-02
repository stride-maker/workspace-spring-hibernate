package com.mohit.aopdemo.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("execution(* com.mohit.aopdemo.service.*.getFortune(..))")
	public Object aroundFortuneService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n\n ====>>> Executing @Around on method: " + method);
		
		long begin = System.currentTimeMillis();
		
		Object result = proceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		long duration = end-begin;
		
		System.out.println("\nDuration: " + duration/1000.0 + " seconds");
				
		return result;
	}
	
	@After("execution(* com.mohit.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyAccountAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n\n ====>>> Executing @After (finally) on method: " + method);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.mohit.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExec"
			)
	public void afterThrowingAccountAdvice(JoinPoint theJoinPoint, Throwable theExec) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n\n ====>>> Executing @AfterThrowing on method: " + method);
		
		System.out.println("\n\n ====>>> Logging the exception: " + theExec);
	}
	
	@AfterReturning(
			pointcut = "execution(* com.mohit.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturningAccountAdvice(JoinPoint theJoinPoint, List<Account> result)  {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n\n ====>>> Executing @AfterReturning on method: " + method);
		
		System.out.println("\n\n ====>>> Result is: " + result);
		
		
		//lets post process the data  ... lets modify it 
		convertAccountNameToUpperCase(result);
		
		System.out.println("\n\n ====>>> After Processing Result is: " + result);
	}
	
	private void convertAccountNameToUpperCase(List<Account> result) {
		
		// loop through the accounts
		// get upper version of name
		// update the name on the account object
		for(Account temp : result) {
		
			String upperName = temp.getName().toUpperCase();
			temp.setName(upperName);
		}
	}

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
