package com.example.models;

import java.util.Date;
import java.util.List;

public class Customer extends Users {

	/*
	 * create table if not exists customer ( c_id int primary key generated always
	 * as identity, first_name varchar(30) not null, last_name varchar(30) not null,
	 * Bob date not null, address varchar(100) not null, phone_no varchar(10), email
	 * varchar(50) not null unique, password varchar(50) not null, is_active bool
	 * not null, start_date date not null, end_date date not null );
	 */
	private int customerId;
	private List<Transactions> transections;
	
	

	// adding into a database
	public Customer(String firstName, String lastName, Date dob, String address, long phoneNo, String email,
			String password, boolean isActive, Date start_date, Date end_date) {
		super(firstName, lastName, dob, address, phoneNo, email, password, isActive, start_date, end_date);
		// TODO Auto-generated constructor stub
	}

	// Retrieving from database
	public Customer(int customerId, String firstName, String lastName, Date dob, String address, long phoneNo,
			String email, String password, boolean isActive, Date start_date, Date end_date) {
		super(firstName, lastName, dob, address, phoneNo, email, password, isActive, start_date, end_date);
		this.customerId = customerId;

	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<Transactions> getTransactions() {
		return transections;
	}

	public void setTransactions(List<Transactions> transections) {
		this.transections = transections;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", transections=" + transections + "]";
	}
	
	

}
