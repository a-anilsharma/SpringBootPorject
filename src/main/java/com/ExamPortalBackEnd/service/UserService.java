package com.ExamPortalBackEnd.service;

import java.util.Set;

import com.ExamPortalBackEnd.Entity.User;
import com.ExamPortalBackEnd.Entity.UserRole;

public interface UserService {
	
	//creating a user
	public User  createUser(User user, Set<UserRole> userRoles) throws Exception ;
	
	//get user
	public User getUser(String username);
	//delete user
	public String deleteUser(Long id);

}
