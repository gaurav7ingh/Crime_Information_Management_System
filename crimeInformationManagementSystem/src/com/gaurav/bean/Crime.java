package com.gaurav.bean;

import java.sql.Date;

public class Crime {
	private int case_no;
	private String crimeName;
	private Integer CriminalId;
	private Date dateOfCrime;
	private String placeOfCrime;
	private String victims;
	private String suspect;
	private String status;
	private String CrimeDesc;

	public Crime(String crimeName, Integer criminalId, Date dateOfCrime, String placeOfCrime, String victims,
			String suspect, String status, String crimeDesc) {
		super();
		this.crimeName = crimeName;
		CriminalId = criminalId;
		this.dateOfCrime = dateOfCrime;
		this.placeOfCrime = placeOfCrime;
		this.victims = victims;
		this.suspect = suspect;
		this.status = status;
		CrimeDesc = crimeDesc;
	}

	public Crime(int case_no, String crimeName, Integer criminalId, Date dateOfCrime, String placeOfCrime,
			String victims, String suspect, String status, String crimeDesc) {
		super();
		this.case_no = case_no;
		this.crimeName = crimeName;
		CriminalId = criminalId;
		this.dateOfCrime = dateOfCrime;
		this.placeOfCrime = placeOfCrime;
		this.victims = victims;
		this.suspect = suspect;
		this.status = status;
		CrimeDesc = crimeDesc;
	}

	public int getCase_no() {
		return case_no;
	}

	public void setCase_no(int case_no) {
		this.case_no = case_no;
	}

	public String getCrimeName() {
		return crimeName;
	}

	public void setCrimeName(String crimeName) {
		this.crimeName = crimeName;
	}

	public Integer getCriminalId() {
		return CriminalId;
	}

	public void setCriminalId(Integer criminalId) {
		CriminalId = criminalId;
	}

	public Date getDateOfCrime() {
		return dateOfCrime;
	}

	public void setDateOfCrime(Date dateOfCrime) {
		this.dateOfCrime = dateOfCrime;
	}

	public String getPlaceOfCrime() {
		return placeOfCrime;
	}

	public void setPlaceOfCrime(String placeOfCrime) {
		this.placeOfCrime = placeOfCrime;
	}

	public String getVictims() {
		return victims;
	}

	public void setVictims(String victims) {
		this.victims = victims;
	}

	public String getSuspect() {
		return suspect;
	}

	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCrimeDesc() {
		return CrimeDesc;
	}

	public void setCrimeDesc(String crimeDesc) {
		CrimeDesc = crimeDesc;
	}

	@Override
	public String toString() {
		if (CriminalId != -1) {
			return "Crime"+"\n==================================================="
					+"\n Case Id \t\t\t = \t"+case_no
					+"\n Status \t\t\t = \t"+status
					+"\n Crime \t\t\t = \t"+crimeName
					+"\n Criminal Id \t\t = \t"+CriminalId
					+"\n Suspects \t\t\t = \t"+suspect
					+"\n Date Of Crime \t\t = \t"+dateOfCrime
					+"\n Place Of Crime \t = \t"+placeOfCrime
					+"\n Victims \t\t\t = \t"+victims
					+"\n Crime Description \t = \t"+CrimeDesc
					+"\n==================================================="
					+"\n";
					
		}
		return 	"Crime"+"\n==================================================="
				+"\n Case Id \t\t\t = \t"+case_no
				+"\n Status \t\t\t = \t"+status
				+"\n Crime \t\t\t = \t"+crimeName
				+"\n Criminal Id \t\t = \tCriminal not found yet "
				+"\n Suspects \t\t\t = \t"+suspect
				+"\n Date Of Crime \t\t = \t"+dateOfCrime
				+"\n Place Of Crime \t = \t"+placeOfCrime
				+"\n Victims \t\t\t = \t"+victims
				+"\n Crime Description \t = \t"+CrimeDesc
				+"\n==================================================="
				+"\n";
	}
}
