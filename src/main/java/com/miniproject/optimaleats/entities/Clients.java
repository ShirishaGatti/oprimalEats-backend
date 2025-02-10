package com.miniproject.optimaleats.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Clients {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
	private long clientId;
	
	private String clientName;
	
	private String clientAddress;
	
	private String clientEmail;
	
	private String clientPhoneNo;
	
	private boolean avialable;
	
	private String clientWorkSpace;
	
	private String clientHostel;
	
	 @ManyToOne
	 @JoinColumn(name = "adminId", nullable = false)
	 private Admin admin;

	 
	 public Admin getAdmin() {
			return admin;
	 }

	 public void setAdmin(Admin admin) {
			this.admin = admin;
	 }

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientPhoneNo() {
		return clientPhoneNo;
	}

	public void setClientPhoneNo(String clientPhoneNo) {
		this.clientPhoneNo = clientPhoneNo;
	}

	public boolean isAvialable() {
		return avialable;
	}

	public void setAvialable(boolean avialable) {
		this.avialable = avialable;
	}

	public String getClientWorkSpace() {
		return clientWorkSpace;
	}

	public void setClientWorkSpace(String clientWorkSpace) {
		this.clientWorkSpace = clientWorkSpace;
	}

	public String getClientHostel() {
		return clientHostel;
	}

	public void setClientHostel(String clientHostel) {
		this.clientHostel = clientHostel;
	}
	
	
	
}
