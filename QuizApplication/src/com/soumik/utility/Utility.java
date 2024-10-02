package com.soumik.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utility {
	
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Register Successfully.");
		} 
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getDbConnection() throws SQLException {
		
		String url="jdbc:mysql://localhost:3306/quizdb";
		String userName="root";
		String password="Soumik@1993";
		
		return DriverManager.getConnection(url, userName, password);
		
	}
	
	public static void closeResource(Connection c,Statement s,ResultSet r,PreparedStatement p) {
		
		
			
			try {
				
				
				if(c!=null) {
				c.close();
				
				} 
				
				if(s!=null) {
					s.close();
				} 
				
				if(r!=null) {
					r.close();
				} 
				
				if(p!=null) {
					p.close();
				} 
				
				System.out.println("Resources Closed Successfully..");
		}
			
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	

}
