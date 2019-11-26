package com.punchcard.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.punchcard.beans.User;

public class LoginDAO {
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/punchcard", "root", "root");
			return conn;
		}catch(SQLException e) {
		throw new RuntimeException(e);
		}
	}
	
	public User searchUser(String username, String password) {
		Connection conn = getConnection();
		User user = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from user where username=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()== true)			
			user = new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));					
		} catch (SQLException e) {
			
			throw new RuntimeException();
			
		}finally {
			try {
				conn.close();
				
			}catch(SQLException e){
				
				throw new RuntimeException();
			}
		}
		return user;
	}

}
