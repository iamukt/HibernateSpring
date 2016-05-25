package com.app.demo.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Contact {
	private String email;
	private String name;
	private String password;
	private double subAmount;
	private Date subDate;
	private String gender;
	private String country;
	private List<String> hobbies;

	public Contact() {
		// TODO Auto-generated constructor stub
		System.out.println("Hi .... I am second");
	}

	public Contact(String email, String name, String password,
			double subAmount, Date subDate, String gender, String country,
			List<String> hobbies) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.subAmount = subAmount;
		this.subDate = subDate;
		this.gender = gender;
		this.country = country;
		this.hobbies = hobbies;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSubAmount() {
		return subAmount;
	}

	public void setSubAmount(double subAmount) {
		this.subAmount = subAmount;
	}

	public Date getSubDate() {
		return subDate;
	}

	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Contact [email=" + email + ", name=" + name + ", subAmount="
				+ subAmount + ", subDate=" + subDate + ", gender=" + gender
				+ ", country=" + country + ", hobbies="
				+ hobbies + "]";
	}

}
