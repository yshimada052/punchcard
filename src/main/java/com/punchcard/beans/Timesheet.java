package com.punchcard.beans;

/**
 * Timesheet class holds hours per day of the week.
 * 
 * Each hour cannot exceed 24 hours
 * @author yshim
 * @Excepion IllegalArgumentException when the hours per day 
 * exceeds 24 hours
 */

import java.sql.Date;
//import java.sql.SQLException;

public class Timesheet {
	private int TimesheetId;
	private double MonHours;
	private double TueHours;
	private double WedHours;
	private double ThuHours;
	private double FriHours;
	private double SatHours;
	private double SunHours;
	private Date weekEnding;
	public Timesheet() {
		super();		
	}
	public Timesheet(int timesheetId, double monHours, double tueHours, double wedHours, double thuHours, double friHours,
			double satHours, double sunHours, Date weekEnding) {
		super();
		TimesheetId = timesheetId;
		MonHours = monHours;
		TueHours = tueHours;
		WedHours = wedHours;
		ThuHours = thuHours;
		FriHours = friHours;
		SatHours = satHours;
		SunHours = sunHours;
		this.weekEnding = weekEnding;
	}
	
	public Timesheet(int int1) {
		// TODO Auto-generated constructor stub
	}
	public int getTimesheetId() {
		return TimesheetId;
	}
	public void setTimesheetId(int timesheetId) {
		TimesheetId = timesheetId;
	}
	public double getMonHours() {
		if(MonHours > 24) {
			throw new IllegalArgumentException();
		}
		return MonHours;
	}
	public void setMonHours(double monHours) {
		MonHours = monHours;
	}
	public double getTueHours() {
		if(TueHours > 24) {
			throw new IllegalArgumentException();
		}
		return TueHours;
	}
	public void setTueHours(double tueHours) {
		TueHours = tueHours;
	}
	public double getWedHours() {
		if(WedHours > 24) {
			throw new IllegalArgumentException();
		}
		return WedHours;
	}
	public void setWedHours(double wedHours) {
		WedHours = wedHours;
	}
	public double getThuHours() {
		if(ThuHours > 24) {
			throw new IllegalArgumentException();
		}
		return ThuHours;
	}
	public void setThuHours(double thuHours) {
		ThuHours = thuHours;
	}
	public double getFriHours() {
		if(FriHours > 24) {
			throw new IllegalArgumentException();
		}
		return FriHours;
	}
	public void setFriHours(double friHours) {
		FriHours = friHours;
	}
	public double getSatHours() {
		if(SatHours > 24) {
			throw new IllegalArgumentException();
		}
		return SatHours;
	}
	public void setSatHours(double satHours) {
		SatHours = satHours;
	}
	public double getSunHours() {
		if(SunHours > 24) {
			throw new IllegalArgumentException();
		}
		return SunHours;
	}
	public void setSunHours(double sunHours) {
		SunHours = sunHours;
	}
	public Date getWeekEnding() {
		return weekEnding;
	}
	public void setWeekEnding(Date weekEnding) {
		this.weekEnding = weekEnding;
	}
//	@Override
//	public String toString() {
//		return "Timesheet [TimesheetId=" + TimesheetId + ", MonHours=" + MonHours + ", TueHours=" + TueHours
//				+ ", WedHours=" + WedHours + ", ThuHours=" + ThuHours + ", FriHours=" + FriHours + ", SatHours="
//				+ SatHours + ", SunHours=" + SunHours + ", weekEnding=" + weekEnding + "]";
//	}
	
	@Override
	public String toString() {
		return "Timesheet [TimesheetId=" + TimesheetId + "]";
	}
	
	
}
