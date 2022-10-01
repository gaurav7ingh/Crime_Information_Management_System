package com.gaurav.usecase;

import com.gaurav.bean.User;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;

public class RecordsOfThisMonth {
	private int size;
	private String msg;
	public RecordsOfThisMonth(User user) {
		
		CrimeDao dao = new CrimeDaoImpl();
		
		try {
			int records = dao.noOfCrimeRecordedInCurrentMonth(user);
			size = records;
		} catch (CrimeException e) {
			msg = "Number of crimes recorded in the current month : "+ e.getMessage();
			size = -1;
		}
		
	}
	public int getSize() {
		return size;
	}
	
	public String getMsg() {
		return msg;
	}
	
	
}
