package com.example.services;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.AccountDao;
import com.example.models.AccountApplication;


public class AccountApplicationService {
	
	private AccountDao aDao;
	
	public AccountApplicationService(AccountDao aDao) {
		this.aDao = aDao;
	}
	
	public List<AccountApplication> getAllApplications(){
		return aDao.getAllAccountApplications();
	}
	
	
	public AccountApplication accountApplication(int userId,String accountType) {
		
		AccountApplication a = new AccountApplication(userId,accountType);
		
		try {
		aDao.createAccountApplicatio(a);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}
}
