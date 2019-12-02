package com.punchcard.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
	public void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("application/json");
		
//		response.getWriter().println(new ObjectMapper().writeValueAsString(
//				loginService.searchUser(new ObjectMapper().readValue(request.getInputStream(), User.class))));
		
		//response.getWriter().println(new ObjectMapper().writeValueAsString(loginService.searchUser(request.getParameter("userName"),request.getParameter("password"))));
		if(loginService.searchUser(request.getParameter("userName"), request.getParameter("password")) != null) {
			response.sendRedirect("http://localhost:8080/punchcard/main.html");
		}else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.print("<html><body><h1>");
			out.print("Invalid entries. The user that you enter does not exist in our system. Please try again");
			out.print("</h1></body><html>");
		}
		
	}

}
