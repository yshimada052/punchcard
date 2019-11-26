package com.punchcard.service;

import com.punchcard.beans.User;
import com.punchcard.data.LoginDAO;

public class LoginService {

	LoginDAO loginDAO = new LoginDAO();
	
	public User searchUser(String username, String password){
		return loginDAO.searchUser(username, password);
	}

	

	
}
