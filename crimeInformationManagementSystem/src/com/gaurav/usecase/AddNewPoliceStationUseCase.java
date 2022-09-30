package com.gaurav.usecase;

import java.util.Scanner;

import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;

public class AddNewPoliceStationUseCase {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name of police station :-");
		String stationName = sc.next();

		CrimeDao dao = new CrimeDaoImpl();
		String result = dao.addPoliceStation(stationName);
		
		System.out.println(result);
		sc.close();
	}
	
}
