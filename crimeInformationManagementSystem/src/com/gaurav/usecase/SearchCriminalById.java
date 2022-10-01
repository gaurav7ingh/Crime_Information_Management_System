package com.gaurav.usecase;

import com.gaurav.bean.Criminal;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;

public class SearchCriminalById {
	private Criminal criminal;
	private String msg;
	public SearchCriminalById(int id) {
		
		CrimeDao dao = new CrimeDaoImpl();
		
		try {
		 	criminal = dao.searchCriminalById(id);
		 	
		} catch (CrimeException e) {
			msg = (e.getMessage());
		}
	}
	public Criminal getCriminal() {
		return criminal;
	}
	
	public String getMsg() {
		return msg;
	}
	
}
