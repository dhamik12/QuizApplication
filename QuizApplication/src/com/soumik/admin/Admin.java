package com.soumik.admin;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.soumik.service.c.CQuestionService;
import com.soumik.service.java.JavaQuestionService;
import com.soumik.service.sql.SqlQuestionService;


public class Admin {

	
	Scanner scan=null;
	public Admin()
	{
		
		System.out.println("Welcome To Admin Portal");
	}
	public void adminOperation() {
	

		System.out.println("Choose Your Subject :");
		System.out.println("Java-->1");
		System.out.println("SQL-->2");
		System.out.println("C Language-->3");
		
		try {
		scan=new Scanner(System.in);
		int subject=scan.nextInt();
		
		switch(subject) {
		
		case 1: 
			
			System.out.println("Create Java Quiz.");
			JavaQuestionService javaObject =new JavaQuestionService();
			javaObject.javaService();
			break;
			
case 2: 
			
			System.out.println("Create SQL Quiz.");
			SqlQuestionService sqlObject=new SqlQuestionService();
			sqlObject.sqlService();
			break;
			
case 3: 
	
	System.out.println("Create C language Quiz.");
	CQuestionService cObject=new CQuestionService();
	cObject.cService();
	break;
	
	default:
		
		System.out.println("Invalid Input!");
		
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
		
		scan.close();
		
	}

	
	
}
