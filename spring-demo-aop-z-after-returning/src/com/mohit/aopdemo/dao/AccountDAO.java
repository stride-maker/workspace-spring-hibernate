package com.mohit.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mohit.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String accountName;
	private String serviceCode;
	
	public List<Account> findAccounts() {
		
		List<Account> myAccounts = new ArrayList<Account>();
		Account theAccount1 = new Account("John", "Silver");
		Account theAccount2 = new Account("Madhu", "Platinum");
		Account theAccount3 = new Account("Luca", "Gold");
		
		myAccounts.add(theAccount1);
		myAccounts.add(theAccount2);
		myAccounts.add(theAccount3);
		return myAccounts;
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getAccountName() {
		System.out.println(getClass() + ": in get name()");
		return accountName;
	}

	public void setAccountName(String accountName) {
		System.out.println(getClass() + ": in set name()");
		this.accountName = accountName;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in get serviceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in set serviceCode()");
		this.serviceCode = serviceCode;
	}
	
}
