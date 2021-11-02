package com.mohit.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mohit.aopdemo.dao.AccountDAO;
import com.mohit.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account theAccount = new Account();
		
		accountDAO.addAccount(theAccount, false);
		accountDAO.doWork();
		
		accountDAO.setAccountName("First Account Name");
		accountDAO.getAccountName();
		
		accountDAO.setServiceCode("ABCDEF");
		accountDAO.getServiceCode();
			
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
		
		context.close();

	}

}
