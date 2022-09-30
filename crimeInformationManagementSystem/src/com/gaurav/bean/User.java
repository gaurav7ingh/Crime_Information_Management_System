package com.gaurav.bean;

public class User {

	private String name;
	private String email;
	private String password;
	private String place;
	
	public User(String name, String email, String password, String place) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	
	
}
