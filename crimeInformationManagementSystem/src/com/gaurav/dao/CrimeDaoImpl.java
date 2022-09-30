package com.gaurav.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.gaurav.bean.Crime;
import com.gaurav.bean.Criminal;
import com.gaurav.bean.User;
import com.gaurav.exceptions.CrimeException;
import com.gaurav.utility.Util;

public class CrimeDaoImpl implements CrimeDao {

	@Override
	public String addCriminal(Criminal criminal) {
		String message = "Not Inserted...";

		try (Connection conn = Util.getConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into criminal " + "(name,age,gender,address,"
					+ "arrested_place,identity_mark) values(?,?,?,?,?,?)");

			ps.setString(1, criminal.getName());
			ps.setInt(2, criminal.getAge());
			ps.setString(3, Character.toString(criminal.getGender()));
			ps.setString(4, criminal.getAddress());
			ps.setString(5, criminal.getArrestAddress());
			ps.setString(6, criminal.getIdentityMark());

			int i = ps.executeUpdate();
			if (i > 0)
				message = "Criminal is inserted..!";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public String addNewCrime(Crime crime) {
		String message = "Not Inserted...";

		try (Connection conn = Util.getConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into crime (crime_name,criminal_id,crime_date,"
					+ "crime_place,victims,suspect,status,crime_desc) values(?,?,?,?,?,?,?,?)");

			ps.setString(1, crime.getCrimeName());
			int integer = crime.getCriminalId();
			if(integer == 0) {
				ps.setString(2, null);
			}else
				ps.setInt(2, integer);
			ps.setDate(3, crime.getDateOfCrime());
			ps.setString(4, crime.getPlaceOfCrime());
			ps.setString(5, crime.getVictims());
			ps.setString(6, crime.getSuspect());
			ps.setString(7, crime.getStatus());
			ps.setString(8, crime.getCrimeDesc());

			int i = ps.executeUpdate();
			if (i > 0)
				message = "Criminal is inserted..!";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public String addPoliceStation(String stationName) {
		
		String message = "not inserted";
		
		try(Connection conn = Util.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into police_dept values(?)");
			
			ps.setString(1, stationName);
			
			int i =ps.executeUpdate();
			
			if(i>0) message = "police station inserted..!";
			
		}catch(SQLException e){
			message = e.getMessage();
		}
		
		return message;
		
	}

	public List<Crime> findSolvedCase(User user) throws CrimeException{

		List<Crime> crimeList = new ArrayList<>();

		try (Connection conn = Util.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from crime where status = 'solved' and crime_place = ?");
			
			ps.setString(1, user.getPlace());
		    ResultSet rs = ps.executeQuery();
		    
		    while(rs.next()) {
		    	Integer caseNo = rs.getInt(1);
		    	String crimeName = rs.getString(2);
		    	Integer criminalId = rs.getInt(3);
		    	Date crimeDate = rs.getDate(4);
		    	String crimePlace = rs.getString(5);
		    	String victims = rs.getString(6);
		    	String suspect = rs.getString(7);
		    	String status = rs.getString(8);
		    	String desc = rs.getString(9);
		    	
		    	Crime crime = new Crime(caseNo, crimeName, criminalId, crimeDate, crimePlace, victims, suspect, status, desc);
		    	
		    	crimeList.add(crime);
		    }
			
		    if(crimeList.isEmpty()) throw new CrimeException(" No case soved till now");
		} catch (SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		
		return crimeList;
	}
	
	@Override
	public List<Crime> findUnsolvedCase(User user) throws CrimeException {
		List<Crime> crimeList = new ArrayList<>();

		try (Connection conn = Util.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from crime where status = 'not solved' and crime_place = ?");
			
			ps.setString(1, user.getPlace());
		    
			ResultSet rs = ps.executeQuery();
		    
		    while(rs.next()) {
		    	Integer caseNo = rs.getInt(1);
		    	String crimeName = rs.getString(2);
		    	Integer criminalId = rs.getInt(3);
		    	Date crimeDate = rs.getDate(4);
		    	String crimePlace = rs.getString(5);
		    	String victims = rs.getString(6);
		    	String suspect = rs.getString(7);
		    	String status = rs.getString(8);
		    	String desc = rs.getString(9);
		    	
		    	Crime crime = new Crime(caseNo, crimeName, criminalId, crimeDate, crimePlace, victims, suspect, status, desc);
		    	
		    	crimeList.add(crime);
		    }
			
		    if(crimeList.isEmpty()) throw new CrimeException("All cases are solved");
		} catch (SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		
		return crimeList;
	}

	
	@Override
	public int noOfCrimeRecordedInCurrentMonth(User user) throws CrimeException {
		int crimes = 0;
		
		try (Connection conn = Util.getConnection()) {
			LocalDate lc = LocalDate.now();
			Date date = Date.valueOf(lc);
			int year = lc.getYear();
			int month = lc.getMonthValue();
			Date StartOfMonth = Date.valueOf(LocalDate.of(year, month, 1));
			
			PreparedStatement ps = conn.prepareStatement("select count(*) from crime where crime_date between ? and ? and crime_place = ?");
			
			ps.setDate(1, StartOfMonth);
			ps.setDate(2, date);
			ps.setString(3, user.getPlace());
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				crimes = rs.getInt(1);
			}else 
				throw new CrimeException("No Crime is listed in this Month.");
			
		} catch (SQLException e) {
			throw new CrimeException(e.getMessage());
			
		}
		
		
		return crimes;
	}

	
	@Override
	public User getUser(String email, String pass) throws CrimeException {
		User user = null;
		
		try (Connection conn = Util.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from user where email = ? and password = ?");
			
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString(1);
				String place = rs.getString(4);
				 
				user = new User(name, email, pass, place);
			}else
				throw new CrimeException("User Doesn't Exists..!");
			
		} catch (SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		
		return user;
	}

	
}
