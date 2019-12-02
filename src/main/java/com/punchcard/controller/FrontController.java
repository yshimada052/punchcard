package com.punchcard.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.punchcard.beans.Timesheet;
import com.punchcard.data.TimesheetDAO;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private TimesheetController timesheetController = new TimesheetController();
	private LoginController loginController = new LoginController();
	
	protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
//		if(req.getRequestURI().contains("hello")) {
//			resp.getWriter().append("Timesheet API.");
//			resp.setStatus(200);
//		}
		switch (uri) {
		case "/punchcard/api/timesheet":
			if (req.getMethod().equals("POST")) {
				timesheetController.postTimesheet(req, resp);
				return;
			}
			if (req.getMethod().equals("PUT")) {
				timesheetController.putTimesheet(req, resp);
				return;
			}
			if (req.getMethod().equals("GET")) {
				timesheetController.getTimesheet(req, resp);
				return;
			}
			if (req.getMethod().equals("DELETE")) {
				timesheetController.deleteTimesheet(req, resp);
				return;
			}
		case "/punchcard":
			if (req.getMethod().equals("POST")) {
				loginController.getUser(req, resp);
				return;
			}
				
			
		default:
			break;
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		out.println("Test");
		
		response.sendRedirect("http://localhost:8080/punchcard/main.html");
		
		TimesheetDAO ts  = new TimesheetDAO();
		
		out.println(ts.findAll().toString());
		System.out.println(ts.findAll());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
