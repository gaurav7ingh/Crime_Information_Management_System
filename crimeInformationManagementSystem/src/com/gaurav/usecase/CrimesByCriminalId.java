package com.gaurav.usecase;

import java.util.List;

import com.gaurav.bean.Crime;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;

public class CrimesByCriminalId {
	private int size;
	private String msg;
	private List<Crime> crimes;

	public CrimesByCriminalId(int id) {
		
		CrimeDao dao = new CrimeDaoImpl();
		
		try {
		 	List<Crime> list = dao.searchCrimesOfCriminal(id);
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
