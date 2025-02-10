package com.miniproject.optimaleats.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.optimaleats.entities.GroceryShopes;
import com.miniproject.optimaleats.repository.GroceryShopesRepository;
import com.miniproject.optimaleats.service.GroceryShopesService;

@Service
public class GroceryShopesServiceImpl implements GroceryShopesService{

	@Autowired
	GroceryShopesRepository repository;
	
	
	public GroceryShopesServiceImpl(GroceryShopesRepository repository) {
		this.repository = repository;
	}

	@Override
	public GroceryShopes addStore(GroceryShopes shopes) {
		// TODO Auto-generated method stub
		return repository.save(shopes);
	}

	@Override
	public boolean deleteStore(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public GroceryShopes getStoreById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<GroceryShopes> getAllStores() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public GroceryShopes updateStore(Long id, GroceryShopes shopes) {
		if(repository.existsById(id)) {
			shopes.setShopId(id);
			return repository.save(shopes);
		}
		return null;
	}

	@Override
	public GroceryShopes loginStore(Long id, GroceryShopes shopes) {
		return repository.save(shopes);
	}

	@Override
	public GroceryShopes getGroceryShopesByUserId(GroceryShopes shopes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroceryShopes authenticate(String userId, String password) {
		GroceryShopes shopes =repository.findByUserId(userId);
		if(shopes!=null && shopes.getPassword().equals(password)) {
			return shopes;
		}
		return null;
	}

}
