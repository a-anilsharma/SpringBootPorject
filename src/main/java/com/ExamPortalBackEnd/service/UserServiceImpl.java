package com.ExamPortalBackEnd.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamPortalBackEnd.Entity.User;
import com.ExamPortalBackEnd.Entity.UserRole;
import com.ExamPortalBackEnd.repo.RoleRepository;
import com.ExamPortalBackEnd.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local =this.userRepository.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("User is already there!!");
			throw   new Exception("User already exists");
		}else
		{
			//create new user
			for (UserRole ur: userRoles)
			
				roleRepository.save(ur.getRole());
			
		}
		user.getUserRole().addAll(userRoles);
		local=this.userRepository.save(user);
	
		return local;
	}
	
	
	@Override
	
	public User getUser(String username) {
      
		return this.userRepository.findByUsername(username);
	}


	@Override
	public String deleteUser(Long id) {
		
		if(this.userRepository.existsById(id)) {
		this.userRepository.deleteById(id);
		return "User Deleted Succussfully !!";
		}
		else {
			
			return "Invalid Id!!";
		}
		
		
	}
	
	
}
