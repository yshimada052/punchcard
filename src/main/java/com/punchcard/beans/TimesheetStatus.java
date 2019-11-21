package com.punchcard.beans;

/**
 * TimesheetStatus class holds status of timesheet
 * Submitted, Saved, Approved, Rejected
 * @author yshim
 *
 */

public class TimesheetStatus {
	private int statusId;
	private String status;

	public TimesheetStatus() {
		super();		
	}
	
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public TimesheetStatus(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
