package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Transactions;
import com.example.models.Users;
import com.example.utils.ConnectionUtil;

public class TransactionDaoDB implements TransactionDao {

	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public void createTransaction(Transactions t) {
		
		try {
			Connection con = conUtil.getConnection();
			
			//We first need to set autocommit to false
			con.setAutoCommit(false);
			String sql = "call create_transaction(?,?,?,?)";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.setInt(1, t.getUserId());
			cs.setString(2, t.getTransactionType());
			cs.setString(3, t.getStatus());
			cs.setDouble(4, t.getRequestedAmount());
			
			cs.execute();
			
			con.setAutoCommit(true);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Transactions> getAllTransactions() {
		List<Transactions> tList = new ArrayList<Transactions>(); 
		
		try {
			
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			
			//Use this syntax for a stored function
			String sql = "{?=call get_all_transactions()}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.OTHER);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				//Result set is based on the return from the function, it returns username, postID, authorID, wallID, content in that order
				//int customerId, int employeeId, String transectionType, String status, double requestedAmount
				Transactions t = new Transactions(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
				tList.add(t);
			}
			
			con.setAutoCommit(true);
			return tList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Users getUserTransaction(Users u) {
		
		List<Transactions> tList = new ArrayList<Transactions>();
		
		try {
			
			Connection con = conUtil.getConnection();
			
			con.setAutoCommit(false);
			
			String sql = "{?=call get_user_posts(?)}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.OTHER);
			cs.setInt(2, u.getUser_id());
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Transactions t = new Transactions(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
				tList.add(t);
			}
			
			u.settList(tList);
			
			con.setAutoCommit(true);
			
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
