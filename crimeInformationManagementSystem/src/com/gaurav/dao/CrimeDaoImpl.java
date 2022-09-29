package com.gaurav.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gaurav.bean.Crime;
import com.gaurav.bean.Criminal;
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
			ps.setString(3, crime.getDateOfCrime());
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

}
