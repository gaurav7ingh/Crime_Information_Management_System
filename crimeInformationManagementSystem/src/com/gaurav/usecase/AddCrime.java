package com.gaurav.usecase;

import com.gaurav.bean.Crime;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import java.sql.Date;
import java.util.Scanner;

public class AddCrime {

	public void main(Scanner sc) {

		System.out.println("Enter the name of Crime");
		String name = sc.next();

		sc.nextLine();
		System.out.println("Enter the id of Criminal");
		System.out.println("If you don't know the who is the Criminal enter -1");
		int id = Integer.parseInt(sc.nextLine());
		boolean flag = true;
		Date dateOfCrime = null;
		while (flag) {
			System.out.println("Enter the date of crime");
			System.out.println("in this format 'yyyy-mm-dd' ");
			try {
				dateOfCrime = Date.valueOf(sc.nextLine());
				flag = false;
			} catch (IllegalArgumentException e) {
				
			}
		}

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

	}


}
