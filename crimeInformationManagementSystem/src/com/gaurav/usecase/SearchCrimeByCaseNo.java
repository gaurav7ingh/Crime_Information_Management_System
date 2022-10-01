package com.gaurav.usecase;

import com.gaurav.bean.Crime;
import com.gaurav.bean.User;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;

public class SearchCrimeByCaseNo {
	private Crime crime;
	private String msg;
	public SearchCrimeByCaseNo(User user,int id) {
		
		CrimeDao dao = new CrimeDaoImpl();
		
		try {
		 	crime = dao.serchCrimeById(user, id);
		 	
		} catch (CrimeException e) {
			msg = (e.getMessage());
		}
	}
	public Crime getCrime() {
		return crime;
	}
	
	public String getMsg() {
		return msg;
	}
	
}
