package com.punchcard.service;

import java.util.List;
import java.util.Set;

import com.punchcard.beans.Timesheet;
import com.punchcard.data.TimesheetDAO;

public class TimesheetService {
	TimesheetDAO timesheetDAO = new TimesheetDAO();
		
	public Timesheet findTimesheetById(int id) {
		return timesheetDAO.findTimesheetById(id);
	}

//	public List<Timesheet> findAll() {
//		return timesheetDAO.findAll();
//	}
//	
//	public Timesheet save(Timesheet timesheet) {
//		return timesheetDAO.save(timesheet);
//	}
//
//	public Set<Timesheet> searchByName(String search) {
//		return timesheetDAO.searchByName(search);
//	}
//
//	public void update(Timesheet timesheet) {
//		timesheetDAO.update(timesheet);
//	}
//
//	public void delete(int id) {
//		timesheetDAO.delete(id);
//	}
//
}
