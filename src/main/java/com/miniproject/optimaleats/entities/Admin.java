package com.miniproject.optimaleats.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Admin {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
	private long adminId;
	
	private String adminName;
	
	private String adminContact;
	
	private String adminAddress;
	
	private String messName;
	
	private double amountPerPlate;
	
	private String time;
	
	private String password;
	
	private int plateCount;
	
	private String menu;
	
	private String rules;
	
	private String userId;
	//studetn ch ek list denar ani samor toogle on by default nasel tr admin off karun totalcount baghanr 
	
	//shopping list 
	//itemcount,platecount,billify,menu
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@OneToOne(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private ShoppingList shoppingList;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true) // display karayla menu ani home page var review 
	private List<itemDetails>items = new ArrayList<>();
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Organizations>organizations = new ArrayList<>();
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<GroceryShopes> shops = new ArrayList<>();
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Clients>clients=new ArrayList<>();
	
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Bill> bills = new ArrayList<>();

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

	public int getPlateCount() {
		return plateCount;
	}

	public void setPlateCount(int plateCount) {
		this.plateCount = plateCount;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}

	public List<itemDetails> getItems() {
		return items;
	}

	public void setItems(List<itemDetails> items) {
		this.items = items;
	}

	public List<Organizations> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organizations> organizations) {
		this.organizations = organizations;
	}

	public List<GroceryShopes> getShops() {
		return shops;
	}

	public void setShops(List<GroceryShopes> shops) {
		this.shops = shops;
	}

	public List<Clients> getClients() {
		return clients;
	}

	public void setClients(List<Clients> clients) {
		this.clients = clients;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminContact=" + adminContact
				+ ", adminAddress=" + adminAddress + ", messName=" + messName + ", amountPerPlate=" + amountPerPlate
				+ ", time=" + time + ", password=" + password + ", plateCount=" + plateCount + ", menu=" + menu
				+ ", rules=" + rules + ", userId=" + userId + ", shoppingList=" + shoppingList + ", items=" + items
				+ ", organizations=" + organizations + ", shops=" + shops + ", clients=" + clients + ", bills=" + bills
				+ "]";
	}
	
}
