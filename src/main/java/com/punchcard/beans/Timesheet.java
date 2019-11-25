package com.punchcard.beans;

/**
 * Timesheet class holds hours per day of the week.
 * 
 * Each hour cannot exceed 24 hours
 * @author yshim
 * @Excepion IllegalArgumentException when the hours per day 
 * exceeds 24 hours
 */

import java.util.Date;
//import java.sql.SQLException;

public class Timesheet {
	
	private int timesheetId;
	private int userId;
	private int statusId;
	private double monHours;
	private double tueHours;
	private double wedHours;
	private double thuHours;
	private double friHours;
	private double satHours;
	private double sunHours;
	private Date weekEnding;
	private Date approvedDate;
	private int approverId;

	public Timesheet() {
		super();		
	}
	
	
	public Timesheet(int timesheetId, int userId, int statusId, double monHours, double tueHours, double wedHours,
			double thuHours, double friHours, double satHours, double sunHours, Date weekEnding, Date approvedDate, int approverId) {
		super();
		this.timesheetId = timesheetId;
		this.userId = userId;
		this.statusId = statusId;
		this.monHours = monHours;
		this.tueHours = tueHours;
		this.wedHours = wedHours;
		this.thuHours = thuHours;
		this.friHours = friHours;
		this.satHours = satHours;
		this.sunHours = sunHours;
		this.weekEnding = weekEnding;
		this.approvedDate = approvedDate;
		this.approverId = approverId;
	}
	
		
	public Timesheet(int timesheetId, int userId, int statusId) {
		super();
		this.timesheetId = timesheetId;
		this.userId = userId;
		this.statusId = statusId;
	}


	public int getTimesheetId() {
		
		return timesheetId;
	}
	
	public void setTimesheetId(int timesheetId) {
		
		this.timesheetId = timesheetId;
	}
	
	public int getUserId() {
		
		return userId;
	}
	
	public void setUserId(int userId) {
		
		this.userId = userId;
	}
	
	public int getStatusId() {
		
		return statusId;
	}
	
	public void setStatusId(int statusId) {
		
		this.statusId = statusId;
	}

	public int getApproverId() {
		
		return approverId;
	}

	public void setApproverId(int approverId) {
		
		this.approverId = approverId;
	}

	public double getMonHours() {
		
		return monHours;
	}
	
	public void setMonHours(double monHours) {
		
		if(monHours > 24) {
			throw new IllegalArgumentException();
		}
		this.monHours = monHours;
	}
	
	public double getTueHours() {
		
		return tueHours;
	}
	
	public void setTueHours(double tueHours) {
		
		if(tueHours > 24) {
			throw new IllegalArgumentException();
		}
		this.tueHours = tueHours;
	}
	
	public double getWedHours() {
		
		return wedHours;
	}
	
	public void setWedHours(double wedHours) {
		
		if(wedHours > 24) {
			throw new IllegalArgumentException();
		}
		this.wedHours = wedHours;
	}
	
	public double getThuHours() {
		
		return thuHours;
	}
	
	public void setThuHours(double thuHours) {
		
		if(thuHours > 24) {
			throw new IllegalArgumentException();
		}
		this.thuHours = thuHours;
	}
	
	public double getFriHours() {
		
		return friHours;
	}
	
	public void setFriHours(double friHours) {
		
		if(friHours > 24) {
			throw new IllegalArgumentException();
		}
		this.friHours = friHours;
	}
	
	public double getSatHours() {
		
		return satHours;
	}
	
	public void setSatHours(double satHours) {
		
		if(satHours > 24) {
			throw new IllegalArgumentException();
		}
		this.satHours = satHours;
	}
	
	public double getSunHours() {
		
		return sunHours;
	}
	
	public void setSunHours(double sunHours) {
		
		if(sunHours > 24) {
			throw new IllegalArgumentException();
		}
		this.sunHours = sunHours;
	}
	
	public Date getWeekEnding() {
		return weekEnding;
	}
	
	public void setWeekEnding(Date weekEnding) {
		this.weekEnding = weekEnding;
	}
	
	

	public Date getApprovedDate() {
		return approvedDate;
	}


	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}


//	@Override
//	public String toString() {
//		return "Timesheet [timesheetId=" + timesheetId + ", userId=" + userId + ", statusId=" + statusId + "]";
//	}


	@Override
	public String toString() {
		return "Timesheet [timesheetId=" + timesheetId + ", userId=" + userId + ", statusId=" + statusId + ", monHours="
				+ monHours + ", tueHours=" + tueHours + ", wedHours=" + wedHours + ", thuHours=" + thuHours
				+ ", friHours=" + friHours + ", satHours=" + satHours + ", sunHours=" + sunHours + ", weekEnding="
				+ weekEnding + ", approvedDate=" + approvedDate + ", approverId=" + approverId + "]";
	}

	
	
	
}
