package com.gaurav.usecase;

import java.util.Scanner;

import com.gaurav.bean.Crime;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;

public class AddNewCrimeUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the name of Crime");
		String name = sc.next();

		System.out.println("Enter the id of Criminal or in case you don't know the Criminal enter 0");
		sc.nextLine();
		int id = Integer.parseInt(sc.nextLine());

		System.out.println("Enter the date of crime");
		System.out.println("in this format 'yyyy-mm-dd' ");
		String dateOfCrime = sc.nextLine();

		System.out.println("Enter the address of crime");
		String PlaceOfCrime = sc.nextLine();

		System.out.println("Enter who are the victims of this crime");
		String victims = sc.nextLine();

		System.out.println("Enter who are the suspects of this crime");
		String suspect = sc.nextLine();
		
		System.out.println("Enter the status of case 'solved/not solved'");
		String statusOfCrime = sc.nextLine();
		
		System.out.println("Enter the detailed description of this crime");
		String desc = sc.nextLine();
		
		Crime crime = new Crime(name, id, dateOfCrime, PlaceOfCrime, victims, suspect, statusOfCrime, desc);
		
		CrimeDao crimeDao = new CrimeDaoImpl();
		String str = crimeDao.addNewCrime(crime);
		System.out.println(str);

		sc.close();
	}

}
