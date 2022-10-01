package com.gaurav.app;

import com.gaurav.bean.User;
import com.gaurav.usecase.FindSolvedCase;
import com.gaurav.usecase.FindUnsolvedCases;
import com.gaurav.usecase.RecordsOfThisMonth;

public class UserInterface {
	
	public static void userInterface(User user) {
		System.out.println();
		
		System.out.println("Your Area : "+user.getPlace());
		System.out.println();
		FindSolvedCase solvedCase = new FindSolvedCase(user);
		int solvedCaseNo = solvedCase.getSize();
		
		FindUnsolvedCases unsolvedCase = new FindUnsolvedCases(user);
		int unsolvedCaseNo = unsolvedCase.getSize();
		
		if(solvedCaseNo==-1 && unsolvedCaseNo==-1) {
			System.out.println("Solved Cases : "+solvedCase.getMsg()+"\t\t\t Unsolved Cases : "+unsolvedCase.getMsg());
		}else if(unsolvedCaseNo==-1) {
			System.out.println("Solved Cases : "+solvedCaseNo+"\t\t\t Unsolved Cases : "+unsolvedCase.getMsg());
		}else if(solvedCaseNo==-1) {
			System.out.println("Solved Cases : "+solvedCase.getMsg()+"\t\t\t Unsolved Cases : "+unsolvedCaseNo);
		}else {
			System.out.println("Solved Cases : "+solvedCaseNo+"\t\t\t Unsolved Cases : "+unsolvedCaseNo);
		}
		System.out.println();
		RecordsOfThisMonth getRecordsOfThisMonthUseCase = new RecordsOfThisMonth(user);
		int caseOfThisMonth = getRecordsOfThisMonthUseCase.getSize();
		if(caseOfThisMonth == -1) System.out.println(getRecordsOfThisMonthUseCase.getMsg());
		else System.out.println("Number of crimes recorded in the current month : "+caseOfThisMonth);
		
	}
	
}
