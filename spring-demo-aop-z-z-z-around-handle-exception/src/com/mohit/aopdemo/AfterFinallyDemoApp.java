package com.mohit.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mohit.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = null;
		try {
			// add a boolean to simulate exceptions
			boolean tripWire = true;
			theAccounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program... caught exception: " + e);
		}
		
		System.out.println("\n\nMain Program:  After Throwing Demo App");
		System.out.println("-------");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		context.close();

	}

}
