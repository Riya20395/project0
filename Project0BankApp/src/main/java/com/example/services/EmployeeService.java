package com.example.services;

import com.example.dao.EmployeeDao;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.logging.Logging;
import com.example.models.Employee;
import com.example.models.Users;

public class EmployeeService {
	
	private EmployeeDao eDao;
	
	public EmployeeService(EmployeeDao eDao) {
		this.eDao = eDao;
	}


	public Users signIn(String email, String password) {
		Employee e = eDao.getEmployeeByEmail(email);

		if (e.getEmployeeId() == 0) {
			Logging.logger.warn("User tried logging in that does not exist");
			throw new UserDoesNotExistException();
		} else if (!e.getPassword().equals(password)) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		} else {
			Logging.logger.info("User was logged in");
			return e;
		}
	}

}
