package com.example.models;

public class Transactions {
/*create table if not exists transactions(
	t_id int primary key generated always as identity,
	c_id int references customer(c_id) not null,
	e_id int references employee(e_id) not null,
	t_type varchar(10) not null,
	status varchar(10) not null,
	requested_amount decimal not null
); */
	 private int transactionId;
	 private int customerId;
	 private int employeeId;
	 private String transactionType;
	 private String status;
	 private double requestedAmount;
	 
	 //Adding data into database
	public Transactions(int customerId, int employeeId, String transectionType, String status, double requestedAmount) {
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.transactionType = transectionType;
		this.status = status;
		this.requestedAmount = requestedAmount;
	}
	
	//Retrieving data into database
	public Transactions(int transectionId, int customerId, int employeeId, String transectionType, String status,
			double requestedAmount) {
		this.transactionId = transectionId;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.transactionType = transectionType;
		this.status = status;
		this.requestedAmount = requestedAmount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", customerId=" + customerId + ", employeeId="
				+ employeeId + ", transactionType=" + transactionType + ", status=" + status + ", requestedAmount="
				+ requestedAmount + "]";
	}

}
                                                        