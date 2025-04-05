package com.miniproject.optimaleats.dto;

import java.time.LocalTime;

import jakarta.persistence.Id;

public class AdminDto {
	private long adminId;
	
	private String adminName;
	
	private String adminContact;
	
	private String adminAddress;
	
	private String messName;
	
	private double amountPerPlate;
	
	private String time;
	
	private String password;
	
	private String rules;

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public String getMessName() {
		return messName;
	}

	public void setMessName(String messName) {
		this.messName = messName;
	}

	public double getAmountPerPlate() {
		return amountPerPlate;
	}

	public void setAmountPerPlate(double amountPerPlate) {
		this.amountPerPlate = amountPerPlate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}
	
	
	
}
