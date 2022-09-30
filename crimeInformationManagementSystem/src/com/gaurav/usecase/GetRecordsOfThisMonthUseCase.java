package com.gaurav.usecase;

import com.gaurav.bean.User;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;

public class GetRecordsOfThisMonthUseCase {
	
	public GetRecordsOfThisMonthUseCase(User user) {
		
		CrimeDao dao = new CrimeDaoImpl();
		
		try {
			int records = dao.noOfCrimeRecordedInCurrentMonth(user);
			System.out.println("Number of crimes recorded in the current month : "+records);
		} catch (CrimeException e) {
			e.printStackTrace();
		}
		
	}
	
}
