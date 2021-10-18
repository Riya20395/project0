package com.example.models;

public class Account {

	private int accountId;
	private int userId;
	private long accountNumber;
	private String accountType;
	private float accountBalance;
	
	
	public Account() {
	}

	
	public Account(int userId, String accountType, float accountBalance) {
		this.userId = userId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}


	//Adding data into database
	public Account(int userId, long accountNumber, String accountType, float accountBalance) {
		this.userId = userId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	//Retrieving data from database
	public Account(int accountId, int customerId, long accountNumber, String accountType, float accountBalance) {
		this.accountId = accountId;
		this.userId = customerId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", accountNumber=" + accountNumber
				+ ", accountType=" + accountType + ", accountBalance=" + accountBalance + "]";
	}

}
