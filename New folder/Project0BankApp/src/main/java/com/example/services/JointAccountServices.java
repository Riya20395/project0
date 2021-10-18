package com.example.services;

import java.sql.SQLException;

import com.example.dao.JointaccountDao;
import com.example.models.JointAccount;

public class JointAccountServices {

	private JointaccountDao jaDao;

	public JointAccountServices(JointaccountDao jaDao) {
		this.jaDao = jaDao;
	}

	public JointAccount createJointAccount(int userId, String first, String last, String email, String password,
			String userType) {

		JointAccount ja = new JointAccount(userId, first, last, email, password, userType);

		try {
			jaDao.createJointAccount(ja);
			System.out.println("joint account is created ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("joint account created successfully...");
		return ja;

	}
}
