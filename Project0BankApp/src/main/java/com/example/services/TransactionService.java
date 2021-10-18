package com.example.services;

import java.util.List;

import com.example.dao.TransactionDao;
import com.example.models.Transactions;
import com.example.models.Users;



public class TransactionService {

	private TransactionDao tDao;
	
	
	public void addTransaction(int userId, int wallId, String content) {
		Transactions t = new Transactions();
		tDao.createTransaction(t);
	}
	
	public List<Transactions> getAllPosts(){
		return tDao.getAllTransactions();
	}
	
	public Users loadUserPosts(Users u) {
		return tDao.getUserTransaction(u);
	}
}
