package com.gaurav.usecase;

import java.util.Scanner;

import com.gaurav.bean.User;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;

public class Main {
	public static void main(String[] args) {
		CrimeDao dao = new CrimeDaoImpl();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your email : ");
		String email = sc.next();
		System.out.println("Enter Your Password : ");
		String pass = sc.next();
		
		User user = null;
		try {
			user = dao.getUser(email, pass);
		} catch (CrimeException e) {
			e.printStackTrace();
		}
		
		if(user!=null) {
			
		}
		
		sc.close();
	}
}
