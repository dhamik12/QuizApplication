package com.soumik.service.c;

import java.util.Scanner;

import com.soumik.service.QuestionService;


public class CQuestionService implements QuestionService{
	
	Scanner scan=null;
	public CQuestionService()
	{
		
		System.out.println("Welcome to C Question Service.");
		
	}	
	
	public void cService()
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
			 System.out.println("You are creating a Java Quiz: ");
			 create();
			 break;
			 
		case 2: 
			System.out.println("You are Updating the the Java Quiz");
			update();
			break;
			
		case 3: 
			System.out.println("You are deleting the the Java Quiz");
			delete();
			break;
			
		case 4: 
			System.out.println("You are displaying  the the Java Quiz");
			display();
			break;
			
			
			default:
				System.out.println("Invalid Input!");
		       
		}
		
		scan.close();
	}

	@Override
	public void create() {
		
		CreateCQuiz ccq=new CreateCQuiz();
		ccq.createquiz();
		
	}

	@Override
	public void display() {
	
		DisplayCQuiz dcq=new DisplayCQuiz();
		dcq.displayQuiz();
		
	}

	@Override
	public void delete() {
	
		DeleteCQuiz dcq=new DeleteCQuiz();
		dcq.deleteQuiz();
	}

	@Override
	public void update() {
		
		UpdateCQuiz ucq=new UpdateCQuiz();
		ucq.updateQuiz();
	}

}
