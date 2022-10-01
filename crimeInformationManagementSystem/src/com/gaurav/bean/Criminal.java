package com.gaurav.bean;

public class Criminal {
	private int id;
	private String name;
	private int age;
	private char gender;
	private String address;
	private String arrestAddress;
	private String identityMark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getArrestAddress() {
		return arrestAddress;
	}
	public void setArrestAddress(String arrestAddress) {
		this.arrestAddress = arrestAddress;
	}
	public String getIdentityMark() {
		return identityMark;
	}
	public void setIdentityMark(String identityMark) {
		this.identityMark = identityMark;
	}
	public Criminal(int id, String name, int age, char gender, String address, String arrestAddress,
			String identityMark) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.arrestAddress = arrestAddress;
		this.identityMark = identityMark;
	}
	
	@Override
	public String toString() {
		return "==================================================="
				+"\n Id \t\t\t\t = \t"+id
				+"\n Name \t\t\t = \t"+name
				+"\n Age \t\t\t\t = \t"+age
				+"\n Gender Id \t\t = \t"+gender
				+"\n Address \t\t\t = \t"+address
				+"\n Arrestin Address \t = \t"+arrestAddress
				+"\n Identity Mark \t\t = \t"+identityMark
				+"\n==================================================="
				+"\n";
	}
	
	
	public Criminal() {
		// TODO Auto-generated constructor stub
	}
}
