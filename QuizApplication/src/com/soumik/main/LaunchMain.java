package com.soumik.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.soumik.admin.Admin;
import com.soumik.player.PlayQuiz;

public class LaunchMain {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Quiz Application.");
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose Your Role:");
		System.out.println("Admin Access--> Press 1");
		System.out.println("Player --> Press 2");

		try {
		int role=sc.nextInt();
		if(role==1) {
			
			System.out.println("Admin Access Granted.....");
			Admin admin=new Admin();
			admin.adminOperation();
			
		}
	
		else if (role==2) {
			
			System.out.println("Player role Granted....");
			
			PlayQuiz play=new PlayQuiz();
			play.fetchingQuiz();
			play.getAnswer();
		}
		
		else {
			
			System.out.println("Invalid Input");
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
		
		sc.close();
	}

}
