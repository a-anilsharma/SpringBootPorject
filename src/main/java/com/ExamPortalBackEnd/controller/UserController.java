package com.ExamPortalBackEnd.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExamPortalBackEnd.Entity.Role;
import com.ExamPortalBackEnd.Entity.User;
import com.ExamPortalBackEnd.Entity.UserRole;
import com.ExamPortalBackEnd.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;
	//create user
	
	@PostMapping("/") 
	public User createUser(@RequestBody User user)  throws Exception{
		System.out.println("In create User method");
		Set<UserRole> roles = new HashSet<>();
		
		Role role = new Role();
		
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		roles.add(new UserRole(user,role));
		
		 User local =this.userService.createUser(user, roles);
		
		return local;
		
	}  
	
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username ) {
		System.out.println(" Get user");
		
	 return this.userService.getUser(username);
		
	}
	
	@DeleteMapping("/{id}")
public String  deleteUser(@PathVariable("id") Long id) {
		
		System.out.println("In delete function");
		
		return this.userService.deleteUser(id);
	}



}
