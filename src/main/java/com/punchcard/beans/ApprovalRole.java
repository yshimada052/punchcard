package com.punchcard.beans;

public class ApprovalRole {
	private int roleId;
	private String role;

	public ApprovalRole() {
		super();		
	}

	public ApprovalRole(String role) {
		super();
		this.role = role;
	}
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
