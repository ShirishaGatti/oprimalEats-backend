package com.miniproject.optimaleats.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Organizations {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
	private long orgId;
	
	private String orgName;
	
	private String orgAddress;
	
	//private String message;
	
	private String ogrEmail;
	
	private String orgPhoneNo;
	
	private String description;
	
	private String password;

	
	@ManyToOne
    @JoinColumn(name = "adminId", nullable = false)
	private Admin admin;
	 
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public String getOgrEmail() {
		return ogrEmail;
	}

	public void setOgrEmail(String ogrEmail) {
		this.ogrEmail = ogrEmail;
	}

	public String getOrgPhoneNo() {
		return orgPhoneNo;
	}

	public void setOrgPhoneNo(String orgPhoneNo) {
		this.orgPhoneNo = orgPhoneNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
