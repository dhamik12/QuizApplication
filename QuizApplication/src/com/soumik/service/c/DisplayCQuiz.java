package com.soumik.service.c;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.soumik.utility.Utility;

public class DisplayCQuiz {
	
	Connection connect=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	Scanner sc=null;
	ResultSet result=null;
	
			public void displayQuiz()
			{
				
				try {
					connect=Utility.getDbConnection();
					if(connect!=null) {
						
						String query="Select * from  cquiz";
						stmt=connect.createStatement();
						if(stmt!=null) {
							
							result=stmt.executeQuery(query);
							
							if(result!=null) {
								
								System.out.println("QuestionNumber\t\tQuestion\tOption1\tOption2\t Option3\tOption4\tAnswer");
								while(result.next()) {
								
								System.out.println(result.getInt(1)+"\t"+ result.getString(2)+"\t"+ result.getString(3)+"\t"+ result.getString(4)+
										"\t"+ result.getString(5)+ "\t"+ result.getString(6)+ "\t"+ result.getString(7));
								
								}
								
							}
						
							
						}
					}
				} 
				
				
				catch (SQLException e) {
				
					e.printStackTrace();
				}
				
				catch(Exception e) {
					
					e.printStackTrace();
				}
				
				finally {
					
					Utility.closeResource(connect, stmt, result,pstmt);
					
				}
				sc.close();
			}
			
			
}


