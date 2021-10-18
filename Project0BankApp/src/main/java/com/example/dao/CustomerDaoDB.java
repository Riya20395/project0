package com.example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.example.models.Customer;
import com.example.models.Users;
import com.example.utils.ConnectionUtil;

public class CustomerDaoDB implements CustomerDao {

	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public void createCustomer(Customer c) throws SQLException {
		// open connection
		Connection con = conUtil.getConnection();

		// sql string for inserting data
		String sql = "INSERT INTO public.customer(first_name, last_name, dob, address, phone_no, email,password, is_active, start_date, end_date)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, c.getFirstName());
		ps.setString(2, c.getLastName());
		ps.setDate(3, (Date) c.getDob());
		ps.setString(4, c.getAddress());
		ps.setLong(5, c.getPhoneNo());
		ps.setString(6, c.getEmail());
		ps.setString(7, c.getPassword());
		ps.setBoolean(8, c.isActive());
		ps.setDate(9, (Date) c.getStart_date());
		ps.setDate(10, (Date) c.getEnd_date());

		ps.execute();

	}

	@Override
	public void updateCustomer(Customer c) {
		

	}

	@Override
	public void deleteCustomer(Customer c) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Users> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByemail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
