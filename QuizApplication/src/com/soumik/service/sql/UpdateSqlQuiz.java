package com.soumik.service.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.soumik.utility.Utility;

public class UpdateSqlQuiz {
	
	Connection connect=null;
	PreparedStatement pstmt=null;
	Scanner sc=null;
	ResultSet result=null;
	Statement stmt=null;
			public void updateQuiz()
			{
				
				try {
					connect=Utility.getDbConnection();
					if(connect!=null) {
						
						String query="Update  sqlquiz set Question=?,Option1=?,Option2=?,Option3=?,Option4=?,Answer=? where QuestionNumber=?";
						pstmt=connect.prepareStatement(query);
						if(pstmt!=null) {
							
							sc=new Scanner(System.in);
							System.out.println("Enter Question Number You Want To Update :  ");
							Integer questionNumber=sc.nextInt();
							pstmt.setInt(7, questionNumber);
							sc.nextLine();
							System.out.println("Enter Your Question :");
							String question=sc.nextLine();
							pstmt.setString(1,question );
							System.out.println("Enter Option 1 : ");
							String option1=sc.nextLine();
							pstmt.setString(2, option1);
							System.out.println("Enter Option 2 : ");
							String option2=sc.nextLine();
							pstmt.setString(3, option2);
							System.out.println("Enter Option 3 : ");
							String option3=sc.nextLine();
							pstmt.setString(4, option3);
							System.out.println("Enter Option 4 : ");
							String option4=sc.nextLine();
							pstmt.setString(5, option4);
							System.out.println("Enter Correct Answer : ");
							String answer=sc.nextLine();
							pstmt.setString(6, answer);
							
							int rowsAffected=pstmt.executeUpdate();
							if(rowsAffected>0) {
								
								System.out.println("Data Updated Successfully!");
							}
							else {
								
								System.out.println("Failed to update quiz!");
							}
							
						}
					}
				} 
				
				
				catch (SQLException e) {
				
					e.printStackTrace();
				}
				
				finally {
					
					Utility.closeResource(connect, stmt, result,pstmt);
					
				}
				
				sc.close();
			}

}
