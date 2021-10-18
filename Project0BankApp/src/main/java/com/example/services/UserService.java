package com.example.services;

import java.sql.SQLException;

import com.example.dao.UserDao;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UsernameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.Users;

public class UserService {

private UserDao uDao;
	
	public UserService(UserDao u) {
		this.uDao = u;
	}
	
	public Users signUp(String first, String last, String email, String password,String userType) throws UsernameAlreadyExistsException {
		
		Users u = new Users(first, last, email, password, userType);
		
		try {
			uDao.createUser(u);
			Logging.logger.info("New user was registered");
		} catch (SQLException e) {
			Logging.logger.warn("Username created that already exists in the database");
			throw new UsernameAlreadyExistsException();
		}
		
		return u;
	}
	
	public Users signIn(String email, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		
		Users u = uDao.getUserByEmail(email);
		
		if(u.getUser_id() == 0) {
			Logging.logger.warn("User tried logging in that does not exist");
			throw new UserDoesNotExistException();
		}
		else if(!u.getPassword().equals(password)) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("User was logged in");
			return u;
		}
		
	}
	
}
