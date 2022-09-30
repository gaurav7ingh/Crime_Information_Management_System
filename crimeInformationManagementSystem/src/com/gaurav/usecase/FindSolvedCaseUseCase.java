package com.gaurav.usecase;

import java.util.List;
import com.gaurav.bean.Crime;
import com.gaurav.bean.User;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;

public class FindSolvedCaseUseCase {
	
	public FindSolvedCaseUseCase(User user) {
		
		CrimeDao dao = new CrimeDaoImpl();
		
		try {
		 	List<Crime> list = dao.findSolvedCase(user);
		 	System.out.println("Solved Cases = "+list.size());
		} catch (CrimeException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
