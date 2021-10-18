package com.example.dao;

import java.sql.SQLException;

import com.example.models.JointAccount;


public interface JointaccountDao {

	void createJointAccount(JointAccount ja) throws SQLException;
}
