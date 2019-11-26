package com.punchcard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.punchcard.beans.Timesheet;
import com.punchcard.beans.User;
import com.punchcard.service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	
	private LoginService loginService = new LoginService();

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
//		response.getWriter().println(new ObjectMapper().writeValueAsString(
//				loginService.searchUser(new ObjectMapper().readValue(request.getInputStream(), User.class))));
		
		response.getWriter().println(new ObjectMapper().writeValueAsString(loginService.searchUser(request.getParameter("userName"),request.getParameter("password"))));
				
		// headers
		response.setStatus(201);
	}

}
