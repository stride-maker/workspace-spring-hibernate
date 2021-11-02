package com.mohit.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mohit.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = accountDAO.findAccounts(false);
		
		System.out.println("Main Program:  After Returning Demo App");
		System.out.println("-------");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		context.close();

	}

}
