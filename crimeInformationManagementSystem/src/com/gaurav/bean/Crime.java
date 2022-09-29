package com.gaurav.bean;

public class Crime {
	private int case_no;
	private String crimeName;
	private int CriminalId;
	private String dateOfCrime;
	private String placeOfCrime;
	private String victims;
	private String suspect;
	private String status;
	private String CrimeDesc;
	
	public Crime(String crimeName, int criminalId, String dateOfCrime, String placeOfCrime, String victims,
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
	
	public Crime(int case_no, String crimeName, int criminalId, String dateOfCrime, String placeOfCrime, String victims,
			String suspect, String status, String crimeDesc) {
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
	public int getCriminalId() {
		return CriminalId;
	}
	public void setCriminalId(int criminalId) {
		CriminalId = criminalId;
	}
	public String getDateOfCrime() {
		return dateOfCrime;
	}
	public void setDateOfCrime(String dateOfCrime) {
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
}
