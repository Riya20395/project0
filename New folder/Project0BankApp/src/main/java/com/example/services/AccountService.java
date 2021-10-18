package com.example.services;

import java.sql.SQLException;

import com.example.dao.AccountDao;
import com.example.exceptions.AccountDoesNotExistException;
import com.example.exceptions.InsufficientBalanceException;
import com.example.models.Account;


public class AccountService {

	private AccountDao aDao;

	public AccountService(AccountDao aDao) {
		this.aDao = aDao;
	}

	public Account createAccount(int userId, String accountType) {

		Account a = new Account();

		try {
			aDao.createAccount(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

	// withdraw()
	public Account withdraw(long accountNumber, float requestedBalance)
			throws AccountDoesNotExistException, InsufficientBalanceException {
		
		Account a = aDao.getAccountByAccountNumber(accountNumber);
		
		float newBalance = a.getAccountBalance() - requestedBalance;

		if (a.getAccountId() == 0) {
			throw new AccountDoesNotExistException();
			
		} else if (newBalance <= 0) {
			throw new InsufficientBalanceException();
		} else {
			a.setAccountBalance(newBalance);
			aDao.updateAccount(a);
			System.out.println("withdraw successfull");
			System.out.println("currunt balance is  "+newBalance);
			return a;
		}
	}

	// Deposit()
	public Account Deposit(Long accountNumber, float requestedBalance) throws AccountDoesNotExistException {
		
		Account a = aDao.getAccountByAccountNumber(accountNumber);
		
		float newBalance = a.getAccountBalance() +requestedBalance;

		if (a.getAccountId() == 0) {

			throw new AccountDoesNotExistException();
		} else {
			System.out.println("deposite successfull");
			
			a.setAccountBalance(newBalance);
			aDao.updateAccount(a);
			System.out.println("currunt balance is  "+a.getAccountBalance());
			
			return a;
		}

	}

	// transfer()
	public Account transfer(Long accountNumber1, Long accountNumber2, float requestedBalance)
			throws AccountDoesNotExistException {

		Account a1 = aDao.getAccountByAccountNumber(accountNumber1);
		Account a2 = aDao.getAccountByAccountNumber(accountNumber2);

		float newBalance1 = a1.getAccountBalance() - requestedBalance;
		float newBalance2 = a2.getAccountBalance() + requestedBalance;

		if (a1.getAccountId() == 0 || a2.getAccountId() == 0) {

			throw new AccountDoesNotExistException();
		} else {
			a1.setAccountBalance(newBalance1);
			System.out.println("your currunt balance is  "+a1.getAccountBalance());
			aDao.updateAccount(a1);

			a2.setAccountBalance(newBalance2);
			aDao.updateAccount(a2);

			System.out.println("transfer Successful made from " + accountNumber1 + " to " + accountNumber2);

			return a1;
		}
	}

}
