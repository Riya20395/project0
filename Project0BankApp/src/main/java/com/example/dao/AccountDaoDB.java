package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Account;
import com.example.models.AccountApplication;
import com.example.utils.ConnectionUtil;

public class AccountDaoDB implements AccountDao {

	// create connection
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public void createAccountApplicatio(AccountApplication a) throws SQLException {

		Connection con = conUtil.getConnection();

		// We will still create the sql string, but with some small changes
		String sql = "INSERT INTO account_application(user_id, account_type, application_status) values" + "(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, a.getUserId());
		ps.setString(2, a.getAccountType());
		ps.setString(3, a.getApplicationStatus());

		ps.execute();

	}
	@Override
	public AccountApplication getAccountAppByUserId(int userId) {
		
		AccountApplication accApp = new AccountApplication();

		try {
			Connection con = conUtil.getConnection();

			//SELECT acc_app_id, user_id, account_type, application_status
			//FROM public.account_application;

			// String sql = "SELECT * FROM account WHERE users.email = '" + email + "'";
			String sql = "SELECT * FROM account_application WHERE account_application.user_id= '" + userId + "'";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				/*account.setAccountId(rs.getInt(1));
				account.setUserId(rs.getInt(2));
				account.setAccountNumber(rs.getLong(3));
				account.setAccountType(rs.getString(4));
				account.setAccountBalance(rs.getFloat(5));*/
				
				accApp.setAccAppId(rs.getInt(1));
				accApp.setUserId(userId);
				accApp.setAccountType(rs.getString(3));
				accApp.setApplicationStatus(rs.getString(4));
			}

			return accApp;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AccountApplication> getAllAccountApplications() {
		
		List<AccountApplication> accAppList = new ArrayList<AccountApplication >();

		try {
			// Make the actual connection to the db
			Connection con = conUtil.getConnection();

			// Create a simple statement
			String sql = "SELECT * FROM account_application";

			// We need to create a statement with the sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			// We have to loop through the ResultSet and create objects based off the return
			while (rs.next()) {

				accAppList
						.add(new AccountApplication(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}

			return accAppList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void createAccount(Account a) throws SQLException {
		Connection con = conUtil.getConnection();

		// We will still create the sql string, but with some small changes
		String sql = "INSERT INTO account (user_id, account_type, balance)  values" + "(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, a.getUserId());
		ps.setString(2, a.getAccountType());
		ps.setFloat(3, a.getAccountBalance());

		ps.execute();

	}

	@Override
	public void updateAccount(Account a) {
		try {
			Connection con = conUtil.getConnection();

			String sql = "UPDATE account SET user_id=?, account_number=?, account_type=?, balance=?  WHERE account_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, a.getUserId());
			ps.setLong(2, a.getAccountNumber());
			ps.setString(3, a.getAccountType());
			ps.setFloat(4, a.getAccountBalance());
			ps.setInt(5, a.getAccountId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAccount(Account a) {

		try {
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM account WHERE account_id=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a.getAccountId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Account> getAllAccount() {
		List<Account> accountList = new ArrayList<Account>();

		try {
			// Make the actual connection to the db
			Connection con = conUtil.getConnection();

			// Create a simple statement
			String sql = "SELECT * FROM account";

			// We need to create a statement with the sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			// We have to loop through the ResultSet and create objects based off the return
			while (rs.next()) {

				accountList
						.add(new Account(rs.getInt(1), rs.getInt(2), rs.getLong(3), rs.getString(4), rs.getFloat(5)));
			}

			return accountList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account getAccountByAccountNumber(long accountNumber) {
		Account account = new Account();

		try {
			Connection con = conUtil.getConnection();

			// String sql = "SELECT * FROM account WHERE users.email = '" + email + "'";
			String sql = "SELECT * FROM account WHERE account.account_number= '" + accountNumber + "'";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				account.setAccountId(rs.getInt(1));
				account.setUserId(rs.getInt(2));
				account.setAccountNumber(rs.getLong(3));
				account.setAccountType(rs.getString(4));
				account.setAccountBalance(rs.getFloat(5));
			}

			return account;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account getAccountByUserId(int userId) {
		Account account = new Account();

		try {
			Connection con = conUtil.getConnection();

			String sql = "SELECT * FROM account WHERE account.user_id= '" + userId + "'";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				account.setAccountId(rs.getInt(1));
				account.setUserId(rs.getInt(2));
				account.setAccountNumber(rs.getLong(3));
				account.setAccountType(rs.getString(4));
				account.setAccountBalance(rs.getFloat(5));
			}

			return account;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	

}
