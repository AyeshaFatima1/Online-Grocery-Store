package com.spring.restapi.grocerystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restapi.grocerystore.dao.AdminRepository;
import com.spring.restapi.grocerystore.model.Admin;

@Service
public class AdminService {

	@Autowired
	public AdminRepository adminRepository;

	public List<Admin> getAdmins() {
		return adminRepository.findAll();
	}

	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin getAdmin(Integer id) {
		return adminRepository.findById(id).orElseThrow(null);
	}

	public Admin updateAdminDetails(Admin admin) {
		return adminRepository.save(admin);
	}
}
