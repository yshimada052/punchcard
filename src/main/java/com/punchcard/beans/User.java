package com.punchcard.beans;

/**
 * Class User
 * 
 * This class contains user name, password to log into
 * Website that manage user(s) time sheet(s).
 * @author yshim
 *
 */

public class User {
	private int userId;	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int roleId;
	private String jobTitle;
	
	
	public User() {
		super();
	}
	
	
	public User(int userId, String firstName, String lastName, String userName, String password, int roleId,
			String jobTitle) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.jobTitle = jobTitle;
	}


	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", roleId=" + roleId + ", jobTitle=" + jobTitle + "]";
	}
	


}
