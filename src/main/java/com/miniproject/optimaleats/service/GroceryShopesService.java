package com.miniproject.optimaleats.service;

import java.util.List;

import com.miniproject.optimaleats.entities.Admin;
import com.miniproject.optimaleats.entities.GroceryShopes;

public interface GroceryShopesService {
	
	GroceryShopes addStore(GroceryShopes shopes);
	boolean deleteStore(Long id);
	GroceryShopes getStoreById(Long id);
	List<GroceryShopes> getAllStores();
	GroceryShopes updateStore(Long id,GroceryShopes shopes);
    GroceryShopes loginStore(Long id,GroceryShopes shopes);
    GroceryShopes getGroceryShopesByUserId(GroceryShopes shopes);
    GroceryShopes authenticate(String userId, String password);
}
