package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Users;

public interface UserDao {

	void createUser(Users u) throws SQLException;

	void updateUser(Users u);

	void deleteUser(Users u);

	List<Users> getAllUsers();

	Users getUserByEmail(String email);
}
