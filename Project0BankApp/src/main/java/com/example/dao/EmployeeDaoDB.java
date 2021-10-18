package com.example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.example.models.Employee;
import com.example.models.Users;
import com.example.utils.ConnectionUtil;

public class EmployeeDaoDB implements EmployeeDao {

	// create connection
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public void createEmployee(Employee e) throws SQLException {
		// open connection
		Connection con = conUtil.getConnection();

		// sql string for inserting data
		String sql = "INSERT INTO employee(first_name, last_name, dob, address, phone_no, qualification, designation, salary, email,password, is_active, start_date, end_date)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, e.getFirstName());
		ps.setString(2, e.getLastName());
		ps.setDate(3, (Date) e.getDob());
		ps.setString(4, e.getAddress());
		ps.setLong(5, e.getPhoneNo());
		ps.setString(6, e.getEmail());
		ps.setString(7, e.getPassword());
		ps.setBoolean(8, e.isActive());
		ps.setDate(9, (Date) e.getStart_date());
		ps.setDate(10, (Date) e.getEnd_date());

		ps.execute();
	}


	
	@Override
	public void updateemployee(Employee e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(Employee e) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Users> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
