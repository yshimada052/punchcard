package com.punchcard.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//import java.util.Date;
import java.sql.Date;
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
			PreparedStatement stmt = conn.prepareStatement("select * from timesheet where timesheetId=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();			
			timeSheet = new Timesheet(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDate(11),rs.getDate(12),rs.getInt(13));					
		} catch (SQLException e) {
			
			throw new RuntimeException();
			
		}finally {
			try {
				conn.close();
				
			}catch(SQLException e){
				
				throw new RuntimeException();
			}
		}
		return timeSheet;
	}
	
	public List<Timesheet> findAll(){
		
		Connection conn = null;
		LinkedList<Timesheet> allTimesheets = new LinkedList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			conn = getConnection();
			
			ResultSet rs = conn.prepareStatement("select * from timesheet").executeQuery();
			while (rs.next()) {
				Timesheet ts = new Timesheet(rs.getInt(1), rs.getInt(2),rs.getInt(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7),
						rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDate(11),
						rs.getDate(12),rs.getInt(13));
				//Timesheet ts = new Timesheet(rs.getInt(1), rs.getInt(2),rs.getInt(3));
				allTimesheets.add(ts);
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {				
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return allTimesheets;
	}
	
	public void delete(int id){
		
		String sql = "delete from timesheet where timesheetId = ?";
		Connection conn = getConnection();
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
		
	public void update(Timesheet timesheet) {
		
		String sql = "update timesheet set M_hrs = ?, Tu_hrs = ?, W_hrs = ?, "
				+ "Th_hrs = ?, F_hrs = ?, Sa_hrs = ?, S_hrs = ? where timesheetId = ?";
		Connection conn = getConnection();
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, timesheet.getMonHours());
			stmt.setDouble(2, timesheet.getTueHours());
			stmt.setDouble(3, timesheet.getWedHours());
			stmt.setDouble(4, timesheet.getThuHours());
			stmt.setDouble(5, timesheet.getFriHours());
			stmt.setDouble(6, timesheet.getSatHours());
			stmt.setDouble(7, timesheet.getSunHours());
			stmt.setInt(8, timesheet.getTimesheetId());			
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}		
	}
	
	
//	public User findByUsername(String username) {}
	
	public Set<Timesheet> searchByName(String search){
		Connection conn = getConnection();
		Set<Timesheet> results = new HashSet<>();
//		try {
//			PreparedStatement stmt = conn.prepareStatement("select * from artist where name LIKE ?");
//			stmt.setString(1, search + "%");
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				Artist a = new Artist(rs.getInt("artistId"), rs.getString("name"));
//				results.add(a);
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			}
//		}
		return results;
	}	
//	
	public Timesheet save(Timesheet t) {
		
		Connection conn = getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into timesheet( userId, statusId, M_hrs, Tu_hrs, W_hrs, Th_hrs, F_hrs, Sa_hrs, S_hrs, weekending, approvedDate, approverId) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",
					new String[] { "timesheetId" });
			stmt.setInt(1, t.getUserId());
			stmt.setInt(2, t.getStatusId());
			stmt.setDouble(3, t.getMonHours());
			stmt.setDouble(4, t.getTueHours());
			stmt.setDouble(5, t.getWedHours());
			stmt.setDouble(6, t.getThuHours());
			stmt.setDouble(7, t.getFriHours());
			stmt.setDouble(8, t.getSatHours());
			stmt.setDouble(9, t.getSunHours());
			stmt.setDate(10, (Date) t.getWeekEnding());
			stmt.setDate(11, (Date) t.getApprovedDate());
			stmt.setInt(12, t.getApproverId());
			stmt.executeUpdate();			
			ResultSet keys = stmt.getGeneratedKeys();
			while (keys.next()) {
				int timesheetId = keys.getInt(1);
				t.setTimesheetId(timesheetId);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return t;		
	}
}
