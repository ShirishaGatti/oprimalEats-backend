package com.miniproject.optimaleats.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.optimaleats.entities.Admin;
import com.miniproject.optimaleats.exception.ResourceNotFoundException;
import com.miniproject.optimaleats.repository.AdminRepository;
import com.miniproject.optimaleats.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	
	@Autowired
    private final AdminRepository adminRepository;

    
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    
	@Override
	public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
	}

	@Override
	public Admin loginAdmin(Long id, Admin admin) {
    	return adminRepository.save(admin);
	}

	@Override
	public Admin getAdminById(Long adminId) {
	    return adminRepository.findById(adminId)
	            .orElseThrow(() -> new ResourceNotFoundException("Admin not found with ID: " + adminId));
	    }


	@Override
	public Admin updateAdmin(Long id, Admin admin) {
		 if (adminRepository.existsById(id)) {
	            admin.setAdminId(id);
	            return adminRepository.save(admin);
	        }
	        return null;
	}

	@Override
	public boolean deleteAdmin(Long id) {
		 if (adminRepository.existsById(id)) {
	            adminRepository.deleteById(id);
	            return true;
	        }
	        return false;
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin authenticateAdmin(String phoneNo, String password) {
		 Admin admin = adminRepository.findByUserId(phoneNo);
	        if (admin != null && admin.getPassword().equals(password)) {
	            return admin;
	        }
	        return null;
	}

	@Override
	public Admin getAdminByUserId(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

}
