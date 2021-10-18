package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Customer;
import com.example.models.Users;

public interface CustomerDao {

	void createCustomer(Customer c) throws SQLException;

	void updateCustomer(Customer c);

	void deleteCustomer(Customer c);

	List<Users> getAllCustomer();

	Customer getCustomerByemail(String email);

	
}
