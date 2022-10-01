package com.gaurav.usecase;

import java.util.Scanner;
import com.gaurav.bean.User;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;

public class AddNewUser {
	
	public static void main() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The name of officer..");
		String name = sc.next();
		
		System.out.println("Enter the gmail..");
		String gmail = sc.next();
		
		System.out.println("Enter new Password..");
		String pass = sc.next();
		
		System.out.println("Enter your place..");
		String place = sc.next();
		
		
		User user = new User(name, gmail, pass, place);
		
		CrimeDao dao = new CrimeDaoImpl();
		String  result = dao.addUser(user);
		
		System.out.println(result);
		
	}
}
