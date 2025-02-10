package com.miniproject.optimaleats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.optimaleats.entities.GroceryShopes;

public interface GroceryShopesRepository extends JpaRepository<GroceryShopes,Long>{

	GroceryShopes findByUserId(String userId);

}
