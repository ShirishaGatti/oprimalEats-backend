package com.miniproject.optimaleats.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShoppingList {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
	private int shopingListId;
	private List<String> shoppingList;
	
	@ManyToOne
	 @JoinColumn(name = "adminId", nullable = false)
	 private Admin admin;

	 
	 public Admin getAdmin() {
			return admin;
	 }
	public List<String> getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(List<String> shoppingList) {
		this.shoppingList = shoppingList;
	}

	public int getId() {
		return shopingListId;
	}

	public void setId(int id) {
		this.shopingListId = id;
	}
	
	
}
