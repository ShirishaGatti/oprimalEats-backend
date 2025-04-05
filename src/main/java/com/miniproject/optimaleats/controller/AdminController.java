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
import com.miniproject.optimaleats.entities.Admin;
import com.miniproject.optimaleats.exception.ResourceNotFoundException;
import com.miniproject.optimaleats.serviceImpl.AdminServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private AdminServiceImpl adminService;
	
	@PostMapping("/add")
	private ResponseEntity<String> addAdmin(@RequestBody AdminDto dto){
		
		try {
			Admin admin=mapToEntity(dto);
			adminService.addAdmin(admin);
			
			 return ResponseEntity.ok("Admin added successfully");
	    }
		catch(Exception ex) {
	           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred while processing ");
	   }
	}
	
	@PostMapping("/login")
	private ResponseEntity<String>loginAdmin(@RequestBody AdminDto adminDto){
		try {
			 Admin admin = adminService.authenticateAdmin(adminDto.getAdminContact(), adminDto.getPassword());

	            if (admin != null ) {
	            	 session.setAttribute("adminId", admin.getAdminId());
	                return ResponseEntity.ok("login successfull");
	            } else {
	                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	            }
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred while processing ");
		}	
	}
	
	@GetMapping("{adminId}")
	private ResponseEntity<?>getAdminById(@PathVariable Long adminId){
		try {
			Admin admin=adminService.getAdminById(adminId);
			if(admin!=null) {
				AdminDto dto=mapToDTO(admin);
				 return ResponseEntity.ok(dto);
			}
			else {
                throw new ResourceNotFoundException("Admin not found with ID: " + adminId);
            }
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("An unexpected error occurred while retrieving the admin");
        }
	}
	 @GetMapping("/all")
	    public ResponseEntity<?> getAllAdmins() {
	        try {
	        	
	            
	            List<Admin> admins = adminService.getAllAdmins();
	            List<AdminDto> dto = admins.stream()
	                    .map(this::mapToDTO)
	                    .collect(Collectors.toList());
	            return ResponseEntity.ok(dto);
	           
	        } catch (Exception ex) {
	            return ResponseEntity.status(500).body("An unexpected error occurred while retrieving admins");
	        }
	 }
	 
	 @PutMapping("/update/{id}")
	    public ResponseEntity<?> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
	        try {
	            Admin updatedAdmin = adminService.updateAdmin(id, admin);
	            if (updatedAdmin != null) {
	                return ResponseEntity.ok("Admin updated successfully");
	            } else {
	                throw new ResourceNotFoundException("Admin not found with ID: " + id);
	            }
	        } catch (ResourceNotFoundException ex) {
	            return ResponseEntity.status(404).body(ex.getMessage());
	        } catch (Exception ex) {
	            return ResponseEntity.status(500).body("An unexpected error occurred while updating the admin");
	        }
	    }
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String>deleteAdmin(@PathVariable Long id){
		try {
			boolean isDeleted=adminService.deleteAdmin(id);
			if(isDeleted)
			return ResponseEntity.ok("Admin delted successfully");
			else
				 throw new ResourceNotFoundException("Admin not found with ID: " + id); 
	    }
		catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("An unexpected error occurred while deleting the admin");
        }
	}
	private Admin mapToEntity(AdminDto dto) {
        
        Admin admin=new Admin();
        admin.setAdminName(dto.getAdminName());
        admin.setAdminAddress(dto.getAdminAddress());
        admin.setMessName(dto.getMessName());
        admin.setAdminContact(dto.getAdminContact());
        admin.setAmountPerPlate(dto.getAmountPerPlate());
        admin.setPassword(dto.getPassword());
        admin.setRules(dto.getRules());
        admin.setTime(dto.getTime());
        return admin;
    }

    // Helper Method: Convert Ipd Entity to IpdDTO
    private AdminDto mapToDTO(Admin admin) {
      
        AdminDto dto=new AdminDto();
        dto.setAdminId(admin.getAdminId());
        dto.setAdminName(admin.getAdminName());
        dto.setAdminAddress(admin.getAdminAddress());
        dto.setMessName(admin.getMessName());
        dto.setAdminContact(admin.getAdminContact());
        dto.setAmountPerPlate(admin.getAmountPerPlate());
        dto.setPassword(admin.getPassword());
        dto.setRules(admin.getRules());
        dto.setTime(admin.getTime());
        return dto;
    }
}
