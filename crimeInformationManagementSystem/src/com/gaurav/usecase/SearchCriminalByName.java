package com.gaurav.usecase;

import java.util.List;
import com.gaurav.bean.Criminal;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;

public class SearchCriminalByName {
	private int size;
	private String msg;
	private List<Criminal> criminals;

	public SearchCriminalByName(String name) {
		
		CrimeDao dao = new CrimeDaoImpl();
		
		try {
		 	List<Criminal> list = dao.searchCriminalName(name);
		 	size = list.size();
		 	criminals = list;
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

	public List<Criminal> getCriminals() {
		return criminals;
	}

}
