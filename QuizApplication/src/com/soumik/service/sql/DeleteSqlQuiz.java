package com.soumik.service.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.soumik.utility.Utility;

public class DeleteSqlQuiz {
	
	Connection connect=null;
	PreparedStatement pstmt=null;
	Scanner sc=null;
	ResultSet result=null;
	Statement stmt=null;
	
			public void deleteQuiz()
			{
				
				try {
					connect=Utility.getDbConnection();
					if(connect!=null) {
						
						String query="delete  sqlquiz where QuestionNumber=?";
						pstmt=connect.prepareStatement(query);
						if(pstmt!=null) {
							
							sc=new Scanner(System.in);
							System.out.println("Enter Question Number You Want To Delete :  ");
							Integer questionNumber=sc.nextInt();
							pstmt.setInt(1, questionNumber);
							
							int rowsAffected=pstmt.executeUpdate();
							if(rowsAffected>0) {
								
								System.out.println("Data Deleted Successfully!");
								
							}
							else {
								
								System.out.println("Failed to Delete Quiz!");
							}
							
						}
					}
				} 
				
				
				catch (SQLException e) {
				
					e.printStackTrace();
				}
				
				finally {
					
					Utility.closeResource(connect, stmt,result,pstmt);
					
				}
			}

}
