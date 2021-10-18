package com.example.models;

import java.util.Date;

public class Employee extends Users {
	
	private int employeeId;
	private String qualification;
	private String designation;
	private double employeeSalary;
	
	//sending data to data--> id is auto generated
	public Employee(String firstName, String lastName, Date dob, String address, long phoneNo,String qualification,
			String designation, double employeeSalary, String email,
			String password, boolean isActive, Date start_date, Date end_date) {
		super(firstName, lastName, dob, address, phoneNo, email, password, isActive, start_date, end_date);
		// TODO Auto-generated constructor stub
		this.qualification = qualification;
		this.designation = designation;
		this.employeeSalary = employeeSalary;
	}
	
	//Retrieving data from database
	public Employee(int employeeId,String firstName, String lastName, Date dob, String address, long phoneNo,String qualification,
			String designation, double employeeSalary,String email, String password, boolean isActive, Date start_date, Date end_date) {
		super(firstName, lastName, dob, address, phoneNo, email, password, isActive, start_date, end_date);
		this.employeeId = employeeId;
		this.qualification = qualification;
		this.designation = designation;
		this.employeeSalary = employeeSalary;
	}



	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", qualification=" + qualification + ", designation="
				+ designation + ", employeeSalary=" + employeeSalary + "]";
	}
	
	

	
}
