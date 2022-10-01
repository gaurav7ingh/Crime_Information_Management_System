package com.gaurav.usecase;

import java.util.List;
import com.gaurav.bean.Crime;
import com.gaurav.bean.User;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;

public class FindSolvedCase {
	private int size;
	private String msg;
	private List<Crime> solvedCasesList;
	public FindSolvedCase(User user) {
		
		CrimeDao dao = new CrimeDaoImpl();
		
		try {
		 	List<Crime> list = dao.findSolvedCase(user);
		 	size = list.size();
		 	solvedCasesList = list;
		} catch (CrimeException e) {
			msg = (e.getMessage());
			size = -1;
		}
	}
	public int getSize() {
		return size;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public List<Crime> getSolvedCasesList() {
		return solvedCasesList;
	}
	
	
}
