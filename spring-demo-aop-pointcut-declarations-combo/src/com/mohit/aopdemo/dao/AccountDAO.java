package com.mohit.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.mohit.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String accountName;
	private String serviceCode;
	
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
