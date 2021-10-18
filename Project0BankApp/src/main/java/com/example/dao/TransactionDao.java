package com.example.dao;

import java.util.List;

import com.example.models.Transactions;
import com.example.models.Users;

public interface TransactionDao {
	
public void createTransaction(Transactions t);
	
	public List<Transactions> getAllTransactions();
	
	public Users getUserTransaction(Users u);
}
