package com.example.models;

public class JointAccount {
	
	private int jAccountId;
	private int userId;
	private String F_name;
	private String L_name;
	private String email;
	private String password;
	private String userType;
	
	public JointAccount() {
	}

	

	public JointAccount(int userId, String f_name, String l_name, String email, String password, String userType) {
		this.userId = userId;
		F_name = f_name;
		L_name = l_name;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}



	public JointAccount(int jAccountId, int userId, String f_name, String l_name, String email, String password,
			String userType) {
		this.jAccountId = jAccountId;
		this.userId = userId;
		F_name = f_name;
		L_name = l_name;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}



	public int getjAccountId() {
		return jAccountId;
	}

	public void setjAccountId(int jAccountId) {
		this.jAccountId = jAccountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getF_name() {
		return F_name;
	}

	public void setF_name(String f_name) {
		F_name = f_name;
	}

	public String getL_name() {
		return L_name;
	}

	public void setL_name(String l_name) {
		L_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JointAccount [jAccountId=" + jAccountId + ", userId=" + userId + ", F_name=" + F_name + ", L_name="
				+ L_name + ", email=" + email + ", password=" + password + "]";
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	

}