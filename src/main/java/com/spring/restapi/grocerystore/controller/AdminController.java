package com.spring.restapi.grocerystore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restapi.grocerystore.model.Admin;
import com.spring.restapi.grocerystore.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	public AdminService adminService;

    @GetMapping("/home")
    public String homePage() {
    	return "Welcome to GROCERY Mart";
    }
    
	@GetMapping("/")
	public List<Admin> getAdmins(){
		return this.adminService.getAdmins();
	}

	@PostMapping("/signIn")
	public String addAdmin(@RequestBody Admin admin) {
	      this.adminService.addAdmin(admin);
	      return "Admin login Sucessfully......!";
	}

	@GetMapping("/admin/{id}")
	public Admin getAdmin(@PathVariable Integer id) {
		return adminService.getAdmin(id);
	}

	@PutMapping("/updateAdminDetails/{id}")
	public String updateAdminDetails(@RequestBody Admin admin) {
		  this.adminService.updateAdminDetails(admin);
		 return "Details Updated Successfully..";
	}
}
