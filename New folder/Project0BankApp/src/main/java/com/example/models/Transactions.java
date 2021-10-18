package com.example.models;

public class Transactions {
	
	public enum transactionType {
        PAYMENT,
        TRANSFER,
        DEPOSIT
    }

	 private int transactionId;
	 private int userId;
	 private String transactionType;
	 private String status;
	 private double requestedAmount;
	 
	 
	 
	 public Transactions() {
	}

	//Adding data into database
	public Transactions(int userId, String transectionType, String status, double requestedAmount) {
		this.userId = userId;
		this.transactionType = transectionType;
		this.status = status;
		this.requestedAmount = requestedAmount;
	}
	
	//Retrieving data into database
	public Transactions(int transectionId, int customerId, String transectionType, String status,double requestedAmount) {
		this.transactionId = transectionId;
		this.userId = customerId;
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

	public int getUserId() {
		return userId;
	}

	public void setCustomerId(int userId) {
		this.userId = userId;
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
		return "Transactions [transactionId=" + transactionId + ", userId=" + userId  + ", transactionType=" + transactionType + ", status=" + status + ", requestedAmount="
				+ requestedAmount + "]";
	}

}
                                                        