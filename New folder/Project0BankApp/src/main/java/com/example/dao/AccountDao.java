package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Account;
import com.example.models.AccountApplication;


public interface AccountDao {

	void createAccountApplicatio(AccountApplication a) throws SQLException;
	AccountApplication getAccountAppByUserId(int userId);
	List<AccountApplication> getAllAccountApplications();
	
	void createAccount(Account a) throws SQLException;
	
	void updateAccount(Account a);

	void deleteAccount(Account a);

	List<Account> getAllAccount();

	Account getAccountByAccountNumber(long accountNumber);
	Account getAccountByUserId(int userId);

	
}
 