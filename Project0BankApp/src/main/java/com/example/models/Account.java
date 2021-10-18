package com.example.models;

public class Account {
/*
 create table if not exists account(
	account_id int primary key generated always as identity,
	c_id int references customer(c_id) not null,
	acoount_number int not null unique,
	account_type varchar(10) not null,
	balance  decimal not null
);
 * */
	private int accountId;
	private int customerId;
	private long accountNumber;
	private String accountType;
	private int accountBalance;
	
	
	public Account() {
	}

	//Adding data into database
	public Account(int customerId, long accountNumber, String accountType, int accountBalance) {
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	//Retrieving data from database
	public Account(int accountId, int customerId, long accountNumber, String accountType, int accountBalance) {
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", customerId=" + customerId + ", accountNumber=" + accountNumber
				+ ", accountType=" + accountType + ", accountBalance=" + accountBalance + "]";
	}
	
	
	
	

	

	

}
