package com.gaurav.usecase;

import java.util.List;
import com.gaurav.bean.Crime;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;

public class SearchCrimesbyArea {
	private int size;
	private String msg;
	private List<Crime> crimes;

	public SearchCrimesbyArea(String name) {
		
		CrimeDao dao = new CrimeDaoImpl();
		
		try {
		 	List<Crime> list = dao.SearchByArea(name);
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
