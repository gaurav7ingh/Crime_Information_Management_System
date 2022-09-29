package com.gaurav.usecase;

import java.util.Scanner;

import com.gaurav.bean.Criminal;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;

public class AddCriminalUseCase {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name of Criminal");
		String name =sc.next();
		
		System.out.println("Enter the age of Criminal");
		int age =sc.nextInt();
		
		System.out.println("Enter the gender (M/F) of Criminal");
		char[] genderArray = sc.next().toCharArray();
		char gender = genderArray[0];
		
		System.out.println("Enter the address of Criminal");
		String address =sc.next();
		
		System.out.println("Enter the arrest address of Criminal");
		String arrestAddress =sc.next();
		
		System.out.println("Enter the identity mark of Criminal");
		sc.nextLine();
		String identityMark =sc.nextLine();
		
		Criminal criminal = new Criminal();
		criminal.setName(name);
		criminal.setAge(age);
		criminal.setAddress(address);
		criminal.setGender(gender);
		criminal.setArrestAddress(arrestAddress);
		criminal.setIdentityMark(identityMark);
		
		CrimeDao crimeDao = new CrimeDaoImpl();
		String str = crimeDao.addCriminal(criminal);
		System.out.println(str);
		
		sc.close();
	}
	
}
