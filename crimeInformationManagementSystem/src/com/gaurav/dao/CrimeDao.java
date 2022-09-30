package com.gaurav.dao;

import java.util.List;
import com.gaurav.bean.Crime;
import com.gaurav.bean.Criminal;
import com.gaurav.bean.User;
import com.gaurav.exceptions.CrimeException;

public interface CrimeDao {
	
	public String addCriminal(Criminal criminal);
	
	public String addNewCrime(Crime crime);
	
	public String addPoliceStation(String stationName);
	
	public User getUser(String email,String pass) throws CrimeException;
	
	public List<Crime> findSolvedCase(User user) throws CrimeException;
	
	public List<Crime> findUnsolvedCase(User user) throws CrimeException;
	
	public int noOfCrimeRecordedInCurrentMonth(User user) throws CrimeException;
}
