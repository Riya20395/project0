package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.models.JointAccount;
import com.example.utils.ConnectionUtil;


public class JointAccountDaoDB implements JointaccountDao {

	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public void createJointAccount(JointAccount ja) throws SQLException {
		
		Connection con = conUtil.getConnection();

		// We will still create the sql string, but with some small changes
		//INSERT INTO public.joint_account(user_id, first_name, last_name, email, "password", user_type)
		

		String sql = "INSERT INTO joint_account(user_id,first_name, last_name, email, password,user_type) values" + "(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, ja.getUserId());
		ps.setString(2, ja.getF_name());
		ps.setString(3, ja.getL_name());
		ps.setString(4, ja.getEmail());
		ps.setString(5, ja.getPassword());
		ps.setString(6, ja.getUserType());

		ps.execute();

	}

}
