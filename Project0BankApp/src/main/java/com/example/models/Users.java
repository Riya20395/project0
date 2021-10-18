package com.example.models;

import java.util.Date;

public class Users {
	/*
	 * create table if not exists customer ( c_id int primary key generated always
	 * as identity, first_name varchar(30) not null, last_name varchar(30) not null,
	 * dob date not null, address varchar(100) not null, phone_no varchar(10), email
	 * varchar(50) not null unique, password varchar(50) not null, is_active bool
	 * not null, start_date date not null, end_date date not null );
	 */
	private String firstName;
	private String lastName;
	private Date dob;
	private String address;
	private long phoneNo;
	private String email;
	private String password;
	private boolean isActive;
	private Date start_date;
	private Date end_date;

	public Users() {
	}

	public Users(String firstName, String lastName, Date dob, String address, long phoneNo, String email,
			String password, boolean isActive, Date start_date, Date end_date) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "Users [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", address=" + address
				+ ", phoneNo=" + phoneNo + ", email=" + email + ", password=" + password + ", isActive=" + isActive
				+ ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}

}
