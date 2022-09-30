package com.gaurav.usecase;

import java.util.List;

import com.gaurav.bean.Crime;
import com.gaurav.bean.User;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;

public class FindUnsolvedCaseUseCase {
	
	
	public FindUnsolvedCaseUseCase(User user) {
		CrimeDao dao = new CrimeDaoImpl();
		
		try {
			List<Crime> unsolvedCase = dao.findUnsolvedCase(user);
			
			System.out.println("Unsolved Cases = "+unsolvedCase.size());
		} catch (CrimeException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
