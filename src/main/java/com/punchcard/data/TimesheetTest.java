package com.punchcard.data;

import java.text.ParseException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
//import java.util.Date;


import com.punchcard.beans.Timesheet;

public class TimesheetTest {
	public static void main(String[] args) {
		
//		String pattern = "yyyy-MM-dd";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//		//Date date = simpleDateFormat.parse("2018-09-09");
//		
//		Date wEnding = null;
//		try {
//			wEnding = simpleDateFormat.parse("2019-11-24");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Date approved = null;
//		try {
//			approved = (Date) simpleDateFormat.parse("2019-11-25");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Date wEnding = new Date(2019-11-24);
		Date approved = new Date(2019-11-25);		
		Timesheet timeSheet = new Timesheet(4,2,1,9.0,9.0,9.0,9.0,9.0,9.0,9.0, wEnding, approved,4);
		TimesheetDAO ts = new TimesheetDAO();
//		ts.findTimesheetById(1);
//		ts.toString();
//		System.out.println(ts.findTimesheetById(1));
		ts.save(timeSheet);
		
	}
	
	
}
