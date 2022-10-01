package com.gaurav.usecase;

import java.sql.Date;
import java.util.List;

import com.gaurav.bean.Crime;
import com.gaurav.bean.User;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;

public class CrimeByDate {
	private int size;
	private String msg;
	private List<Crime> crimes;

	public CrimeByDate(User user,Date date) {
		
		CrimeDao dao = new CrimeDaoImpl();
		
		try {
		 	List<Crime> list = dao.searchCrimeByDate(user,date);
		 	size = list.size();
		 	crimes = list;
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

	public List<Crime> getCrimes() {
		return crimes;
	}
}
