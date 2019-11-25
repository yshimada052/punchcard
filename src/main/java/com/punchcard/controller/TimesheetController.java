package com.punchcard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.punchcard.beans.Timesheet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.punchcard.service.TimesheetService;

/**
 * Servlet implementation class TimesheetController
 */
@WebServlet("/TimesheetController")
public class TimesheetController extends HttpServlet {
	
	private TimesheetService timesheetService = new TimesheetService();

	// POST /punchcard/api/timesheet
	public void postTimesheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.getWriter().println(new ObjectMapper().writeValueAsString(
				timesheetService.save(new ObjectMapper().readValue(req.getInputStream(), Timesheet.class))));
		// headers
		resp.setStatus(201);
	}

	// GET /punchcard/api/timesheet?id=1
	public void getTimesheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		if (req.getParameter("id") != null) {
			resp.getWriter().println(new ObjectMapper()
					.writeValueAsString(timesheetService.findTimesheetById(Integer.parseInt(req.getParameter("id")))));
		} else if (req.getParameter("name") != null) {
			resp.getWriter().println(
					new ObjectMapper().writeValueAsString(timesheetService.searchByName(req.getParameter("name"))));
		} else {
			resp.getWriter().println(new ObjectMapper().writeValueAsString(timesheetService.findAll()));
		}
	}

	// PUT /punchcard/api/timesheet
	public void putTimesheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		timesheetService.update(new ObjectMapper().readValue(req.getInputStream(), Timesheet.class));
		resp.setStatus(204);
		
	}

	// DELETE /punchcard/api/timesheet?id=1
	public void deleteTimesheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		timesheetService.delete(Integer.parseInt(req.getParameter("id")));
		resp.setStatus(204);
	}

	
}
