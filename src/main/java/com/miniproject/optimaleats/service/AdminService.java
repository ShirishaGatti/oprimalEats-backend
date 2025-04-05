package com.miniproject.optimaleats.service;

import java.util.List;

import com.miniproject.optimaleats.entities.Admin;

public interface AdminService {
	
	   Admin addAdmin(Admin admin);
	    Admin loginAdmin(Long id,Admin admin);
	    Admin getAdminById(Long id);
	    Admin updateAdmin(Long id, Admin admin);
	    boolean deleteAdmin(Long id);
	    List<Admin> getAllAdmins();
		Admin getAdminByUserId(Admin admin);
		Admin authenticateAdmin(String phoneNo, String password);
}
