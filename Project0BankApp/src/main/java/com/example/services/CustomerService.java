package com.example.services;

import com.example.dao.CustomerDao;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.logging.Logging;
import com.example.models.Customer;

public class CustomerService {

	private CustomerDao cDao;

	public CustomerService(CustomerDao cDao) {
		this.cDao = cDao;
	}



	public Customer signIn(String email, String password) {

		Customer c = cDao.getCustomerByemail(email);

		if (c.getCustomerId() == 0) {
			Logging.logger.warn("User tried logging in that does not exist");
			throw new UserDoesNotExistException();
		} else if (!c.getPassword().equals(password)) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		} else {
			Logging.logger.info("User was logged in");
			return c;
		}
	}
	
	
}
