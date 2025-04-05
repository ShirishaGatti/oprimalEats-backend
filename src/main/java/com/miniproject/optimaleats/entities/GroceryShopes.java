package com.miniproject.optimaleats.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class GroceryShopes {
	
	@Id	  
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
	private long shopId;
	
	private String shopName;
	
	private String password;
	
	private String shopAddress;
	
	private String shopMesssae;
	
	private String shopEmail;
	
	private String shopPhoneNo;
	
	private String saleDetails;
	
	private String userId;
	
	@ManyToOne
    @JoinColumn(name = "adminId", nullable = false)
	private Admin admin;	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopMesssae() {
		return shopMesssae;
	}

	public void setShopMesssae(String shopMesssae) {
		this.shopMesssae = shopMesssae;
	}

	public String getShopEmail() {
		return shopEmail;
	}

	public void setShopEmail(String shopEmail) {
		this.shopEmail = shopEmail;
	}

	public String getShopPhoneNo() {
		return shopPhoneNo;
	}

	public void setShopPhoneNo(String shopPhoneNo) {
		this.shopPhoneNo = shopPhoneNo;
	}

	public String getSaleDetails() {
		return saleDetails;
	}

	public void setSaleDetails(String saleDetails) {
		this.saleDetails = saleDetails;
	}
	
	
}
