package com.miniproject.optimaleats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.miniproject.optimaleats.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByUserId(String phoneNo);

}
