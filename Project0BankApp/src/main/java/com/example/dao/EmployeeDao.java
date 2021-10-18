package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Employee;
import com.example.models.Users;

public interface EmployeeDao {
	
	void createEmployee(Employee e) throws SQLException;

	void updateemployee(Employee e);

	void deleteEmployee(Employee e);

	List<Users> getAllEmployees();

	Employee getEmployeeByEmail(String email);

}
