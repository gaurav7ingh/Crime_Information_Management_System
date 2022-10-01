package com.gaurav.usecase;

import java.util.Scanner;

import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;

public class UpdateCrimeStatus {
	
	public static void main() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter the case id for updating the case status..");
		int caseNo = sc.nextInt();
		CrimeDao dao = new CrimeDaoImpl();
		
		String result = dao.updateStatus(caseNo);
		
		System.out.println(result);
		
	}
	
}
