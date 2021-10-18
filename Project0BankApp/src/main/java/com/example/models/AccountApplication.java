package com.example.models;

public class AccountApplication {
	/*acc_app_id int primary key generated always as identity,
	User_id int references users(user_id) not null,
	account_type varchar(20) not null,
	application_status varchar(10) not null*/
	
	private int accAppId;
	private int userId;
	private String accountType;
	private String applicationStatus="pending";
	
	
	
	public AccountApplication() {
	}


	public AccountApplication(int userId, String accountType) {
		this.userId = userId;
		this.accountType = accountType;
		this.applicationStatus="pending";
	}


	public AccountApplication(int accAppId, int userId, String accountType, String applicationStatus) {
		this.accAppId = accAppId;
		this.userId = userId;
		this.accountType = accountType;
		this.applicationStatus = applicationStatus;
	}


	public int getAccAppId() {
		return accAppId;
	}


	public void setAccAppId(int accAppId) {
		this.accAppId = accAppId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getApplicationStatus() {
		return applicationStatus;
	}


	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}


	@Override
	public String toString() {
		return "AccountApplication [accAppId=" + accAppId + ", userId=" + userId + ", accountType=" + accountType
				+ ", applicationStatus=" + applicationStatus + "]";
	}
	
	
}
