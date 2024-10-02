package com.soumik.player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.soumik.pojo.Question;
import com.soumik.utility.Utility;

public class PlayQuiz {
	
	Scanner sc=null;
	HashMap <Integer,Question>map=new HashMap<>();
	HashMap<Integer,Integer> answerSet=new HashMap<>();
	
	String query;
	Connection connect=null;
	Statement stmt=null;
	ResultSet result=null;
	PreparedStatement pstmt=null;
	
	double points;
	public void fetchingQuiz() {
		
		System.out.println("Enter Your Quiz Subject..");
		System.out.println("Play Java Quiz--> Press 1");
		System.out.println("Play SQL Quiz--> Press 2");
		System.out.println("Play C Quiz--> Press 3");
		
		try {
		sc=new Scanner(System.in);
		int subject=sc.nextInt();
		
		if(subject==1) {
			
			query="select * from javaquiz";
		}
		
		else if(subject==2) {
			
			query="select * from sqlquiz";
		}

		else if(subject==3) {
	
			query="select * from cquiz";
			
			}
		
		else {
			
			System.out.println("Invalid Subject Selected..");
		}
		
		}
		

		catch(InputMismatchException e) {
			
			System.out.println("Integer input Excepted!");
			System.out.println("Please Re-run The Program... ");
		}
		
		catch(Exception e) {
			
			System.out.println("Invalid Input!");
			System.out.println("Please Re-run The Program... ");
		}
		
		
		
		try {
			connect=Utility.getDbConnection();
			if(connect!=null) {
			stmt=connect.createStatement();
			if(stmt!=null) {
			result=stmt.executeQuery(query);
			if(result!=null) {
				
				//System.out.println("Question Number\t\tQuestion\tOption 1\tOption 2\tOption 3\tOption 4\tAnswer");
			
			while(result.next()) {
			int questionNumber = result.getInt(1);
			String question=result.getString(2);
			String option1=result.getString(3);
			String option2=result.getString(4);
			String option3=result.getString(5);
			String option4=result.getString(6);
			String answer=result.getString(7);
	
			
			//System.out.println(questionNumber+"\t\t"+question+"\t"+option1+"\t"+option2+"\t"+option3+"\t"+option4+"\t"+answer);
			
			map.put(questionNumber, new Question(question,option1,option2,option3,option4,answer));
			
			}
			
			System.out.println(map);
			}
			
			}
			
			}
		}
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Utility.closeResource(connect, stmt, result, pstmt);
		
	}
	
	
	
	
	public void getAnswer()
	{
		
		Set<Entry<Integer,Question>> set=map.entrySet();
		Iterator<Entry<Integer, Question>> itr=set.iterator();
		while(itr.hasNext()) {
			Entry<Integer,Question> pair=itr.next();
			int key =pair.getKey();
			Question values=pair.getValue();
			System.out.println("Q)"+key);
			System.out.println(values.getQuestion());
			System.out.println("1)"+values.getOption1());
			System.out.println("2)"+values.getOption2());
			System.out.println("3)"+values.getOption3());
			System.out.println("4)"+values.getOption4());

			try {
			sc=new Scanner(System.in);
			System.out.println("Enter Your answer:");
			int playerAnswer=sc.nextInt();
			answerSet.put(key, playerAnswer);
			
			switch(playerAnswer) {
			
			case 1:
				
				if(values.getAnswer().equals(values.getOption1())) {
					System.out.println("Correct!");	
					points++;
				}
				
				else {
					
					System.out.println("Incorrect!");
					points=points-0.25;
				}
			break;
			
			case 2:
				
				if(values.getAnswer().equals(values.getOption2())) {
					System.out.println("Correct!");	
					points++;
				}
				
				else {
					
					System.out.println("Incorrect!");
					points=points-0.25;
				}
			break;
			
	case 3:
	
	if(values.getAnswer().equals(values.getOption3())) {
		System.out.println("Correct!");	
		points++;
	}
	
	else {
		
		System.out.println("Incorrect!");
		points=points-0.25;
	}
	break;

	case 4:
	
	if(values.getAnswer().equals(values.getOption4())) {
		System.out.println("Correct!");	
		points++;
	}
	
	else {
		
		System.out.println("Incorrect!");
		points=points-0.25;
	}
	break;
	
	default: 
		
		System.out.println("Wrong Input!");
		System.out.println("Answer is considered as null.");
			
			}
			
		
		
	 System.out.println("You have Scored:"+points);
		
	}
		
		

		catch(InputMismatchException e) {
			
			System.out.println("Integer input Excepted!");
			System.out.println("Please Re-run The Program... ");
		}
		
		catch(Exception e) {
			
			System.out.println("Invalid Input!");
			System.out.println("Please Re-run The Program... ");
		}
		
		
	}

		sc.close();
}
	
	
}

