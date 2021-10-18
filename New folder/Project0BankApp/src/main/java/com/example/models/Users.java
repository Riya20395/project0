package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Users {

	private int user_id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String userType;
	private List<Transactions> tList;
	

	// no argument constructor
	public Users() {
		settList(new ArrayList<Transactions>());
	}

	// for inserting data into database
	public Users(String firstName, String lastName, String email, String password, String userType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}

	// for retrieving data form database using user_id
	public Users(int user_id, String firstName, String lastName, String email, String password, String userType) {
		this.user_id = user_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", userType=" + userType + "]";
	}

	public List<Transactions> gettList() {
		return tList;
	}

	public void settList(List<Transactions> tList) {
		this.tList = tList;
	}

}
