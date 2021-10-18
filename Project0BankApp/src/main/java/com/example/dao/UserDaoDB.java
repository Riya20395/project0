package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Users;
import com.example.utils.ConnectionUtil;

public class UserDaoDB implements UserDao {

	// create connection
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public void createUser(Users u) throws SQLException {

		Connection con = conUtil.getConnection();

		// We will still create the sql string, but with some small changes
		String sql = "INSERT INTO users(first_name, last_name, email, password,user_type) values" + "(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, u.getFirstName());
		ps.setString(2, u.getLastName());
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getPassword());
		ps.setString(5, u.getUserType());

		ps.execute();
	}

	@Override
	public void updateUser(Users u) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, password = ?, user_type=?"
					+ "WHERE users_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getUserType());
			ps.setInt(6, u.getUser_id());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(Users u) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM users WHERE users_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u.getUser_id());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Users> getAllUsers() {
		List<Users> userList = new ArrayList<Users>();

		try {
			// Make the actual connection to the db
			Connection con = conUtil.getConnection();

			// Create a simple statement
			String sql = "SELECT * FROM users";

			// We need to create a statement with the sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			// We have to loop through the ResultSet and create objects based off the return
			while (rs.next()) {
				userList.add(
						new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6)));
			}

			return userList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public Users getUserByEmail(String email) {

		Users user = new Users();

		try {
			Connection con = conUtil.getConnection();

			String sql = "SELECT * FROM users WHERE users.email = '" + email + "'";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				user.setUser_id(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setUserType(rs.getString(6));
			}

			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
