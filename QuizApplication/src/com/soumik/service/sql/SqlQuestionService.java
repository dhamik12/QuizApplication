package com.soumik.service.sql;

import java.util.Scanner;

import com.soumik.service.QuestionService;


public class SqlQuestionService implements QuestionService {
	
	Scanner scan=null;
	public SqlQuestionService()
	{
		
		System.out.println("Welcome to SQL Question Service.");
		
	}	
	
	public void sqlService()
	{
		
		System.out.println("Please Enter Your  Choice :");
		scan=new Scanner(System.in);
		System.out.println("Create Quiz--->Entter 1");
		System.out.println("Update Quiz--->Enter 2");
		System.out.println("Delete Quiz--->Enter 3");
		System.out.println("Display Quiz---> Enter 4");
		int choice=scan.nextInt();
		
		switch(choice) {
		
		case 1:
			 System.out.println("You are creating a SQL Quiz: ");
			 create();
			 break;
		case 2: 
			System.out.println("You are Updating the the SQL Quiz");
			update();
			break;
			
		case 3: 
			System.out.println("You are deleting the the SQL Quiz");
			delete();
			break;
			
		case 4: 
			System.out.println("You are displaying  the the SQL Quiz");
			display();
			break;
			
			
			default:
				System.out.println("Invalid Input!");
		       
		}
		
		scan.close();
	}

	@Override
	public void create() {
		
		CreateSqlQuiz csq=new CreateSqlQuiz();
		csq.createquiz();
		
	}

	@Override
	public void display() {
	
		DisplaySqlQuiz dsq=new DisplaySqlQuiz();
		dsq.displayQuiz();
		
	}

	@Override
	public void delete() {
	
		DeleteSqlQuiz dsq=new DeleteSqlQuiz();
		dsq.deleteQuiz();
	}

	@Override
	public void update() {
		
		UpdateSqlQuiz usq=new UpdateSqlQuiz();
		usq.updateQuiz();
	}

}
