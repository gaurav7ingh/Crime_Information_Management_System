package com.gaurav.dao;

import com.gaurav.bean.Crime;
import com.gaurav.bean.Criminal;

public interface CrimeDao {
	
	public String addCriminal(Criminal criminal);
	
	public String addNewCrime(Crime crime);
	
}
