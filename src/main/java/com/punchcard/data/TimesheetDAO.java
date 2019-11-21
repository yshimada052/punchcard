package com.punchcard.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.punchcard.beans.Timesheet;
import com.punchcard.beans.User;

public class TimesheetDAO {
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/punchcard", "root", "root");
			return conn;
		}catch(SQLException e) {
		throw new RuntimeException(e);
		}
	}
	
	public Timesheet findTimesheetById(int id) {
		Connection conn = getConnection();
		Timesheet timeSheet = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("select timesheettId, M-hrs, Tu-hrs, W-hrs, Th-hrs, F-hrs, Sa-hrs, S-hrs, weekending from timesheet where timesheetId=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			//timeSheet = new Timesheet(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getDate(9));
			timeSheet = new Timesheet(rs.getInt(1));
			System.out.println(timeSheet);
		} catch (SQLException e) {
			e.getStackTrace();
			//throw new RuntimeException();
		}
		return timeSheet;
	}
	
		
//	public User findByUsername(String username) {}
//	public List<Timesheet> findTimesheetsByUser(int id){}
//	
//	public Timesheet save(Timesheet t) {}
}
