package com.miniproject.optimaleats.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.optimaleats.dto.AdminDto;
import com.miniproject.optimaleats.dto.GroceryShopesDto;
import com.miniproject.optimaleats.entities.Admin;
import com.miniproject.optimaleats.entities.GroceryShopes;
import com.miniproject.optimaleats.exception.ResourceNotFoundException;
import com.miniproject.optimaleats.serviceImpl.AdminServiceImpl;
import com.miniproject.optimaleats.serviceImpl.GroceryShopesServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/store")
public class GroceryShopesController {
	@Autowired
	private GroceryShopesServiceImpl service;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private AdminServiceImpl adminService;
	
	@PostMapping("/add")
	private ResponseEntity<String >addStore(@RequestBody GroceryShopesDto dto){
		try {
			GroceryShopes shopes=mapToEntity(dto);
			Admin admin=adminService.getAdminById( (Long)session.getAttribute("adminId"));
			if(admin!=null) {
				System.out.print(admin);
			shopes.setAdmin(admin);
			}
			else {
				return ResponseEntity.status(404).body("Admin is null");
			}
			service.addStore(shopes);
			return ResponseEntity.ok("Store added successfully");
		}
		catch(Exception ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
		}
	}
	
	@PostMapping("/login")
	private ResponseEntity<?>loginStore(@RequestBody GroceryShopesDto dto){
		try {
			GroceryShopes shopes=service.authenticate(dto.getShopPhoneNo(), dto.getPassword());
			if(shopes!=null) {
				session.setAttribute("StoreId",shopes.getShopId());
                return ResponseEntity.ok("login successfull"); 
			}else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
	}
	catch(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred while processing ");
	}	
	}
	
	@GetMapping("{id}")
	private ResponseEntity<?> getStoreById(@PathVariable Long id) {
		try {
			GroceryShopes shopes=service.getStoreById(id);
			if(shopes!=null){
				GroceryShopesDto dto=mapToDto(shopes);
				 return ResponseEntity.ok(dto);
			}
			else {
                throw new ResourceNotFoundException("Store not found with ID: " + id);
			}
		}
		catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("An unexpected error occurred while retrieving the store");
        }
	}
	
	 @GetMapping("/all")
	    public ResponseEntity<?> getAllStores() {
	        try {
	            List<GroceryShopes> shopes = service.getAllStores();
	            List<GroceryShopesDto>dto=shopes.stream().map(this::mapToDto)
	            		.collect(Collectors.toUnmodifiableList());
	            return ResponseEntity.ok(dto);
	         
	        } catch (Exception ex) {
	            return ResponseEntity.status(500).body("An unexpected error occurred while retrieving stores");
	        }
	 }
	 
	 @PutMapping("/update/{id}")
	    public ResponseEntity<?> updateStore(@PathVariable Long id, @RequestBody GroceryShopesDto dto) {
	        try {
	        	GroceryShopes shopes = service.getStoreById(id);
	            if (shopes == null) {
	                return ResponseEntity.notFound().build();
	            } 
	            Admin admin=null;
	            if(dto.getAdminId()!=null) {
	            
	            	admin = adminService.getAdminById(dto.getAdminId().getAdminId());
	                if (admin == null) {
	                    return ResponseEntity.badRequest().body("Admin not found");
	                }
	                shopes.setAdmin(admin);
	            }
	            shopes.setSaleDetails(dto.getSaleDetails());
	            shopes.setShopAddress(dto.getShopAddress());
	            shopes.setShopEmail(dto.getShopEmail());
	            shopes.setShopMesssae(dto.getShopMesssae());
	            shopes.setShopPhoneNo(dto.getShopPhoneNo());
	            shopes.setUserId(dto.getShopPhoneNo());
	            
	            service.updateStore(id, shopes);
	            return ResponseEntity.ok("Store record updated successfully");

	        } catch (ResourceNotFoundException ex) {
	            return ResponseEntity.status(404).body(ex.getMessage());
	        } catch (Exception ex) {
	            return ResponseEntity.status(500).body("An unexpected error occurred while updating the store details");
	        }
	    }
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String>deleteStore(@PathVariable Long id){
		try {
			boolean isDeleted=service.deleteStore(id);
			if(isDeleted)
			return ResponseEntity.ok("Store delted successfully");
			else
				 throw new ResourceNotFoundException("Store not found with ID: " + id); 
	    }
		catch (ResourceNotFoundException ex) {
         return ResponseEntity.status(404).body(ex.getMessage());
     } catch (Exception ex) {
         return ResponseEntity.status(500).body("An unexpected error occurred while deleting the Store");
     }
	}
	private GroceryShopes mapToEntity(GroceryShopesDto dto) {
		
		GroceryShopes shopes=new GroceryShopes();
		shopes.setShopName(dto.getShopName());
		shopes.setShopAddress(dto.getShopAddress());
		shopes.setShopEmail(dto.getShopEmail());
		shopes.setSaleDetails(dto.getSaleDetails());
		shopes.setShopMesssae(dto.getShopMesssae());
		shopes.setPassword(dto.getPassword());
		shopes.setShopPhoneNo(dto.getShopPhoneNo());
		
		return shopes;
	}
	private GroceryShopesDto mapToDto(GroceryShopes shopes) {
		GroceryShopesDto dto=new GroceryShopesDto();
		dto.setShopId(shopes.getShopId());
		dto.setPassword(shopes.getPassword());
		dto.setSaleDetails(shopes.getSaleDetails());
		dto.setShopAddress(shopes.getShopAddress());
		dto.setShopEmail(shopes.getShopEmail());
		dto.setShopMesssae(shopes.getShopMesssae());
		dto.setShopName(shopes.getShopName());
		dto.setShopPhoneNo(shopes.getShopPhoneNo());
		return dto;
	}
}
