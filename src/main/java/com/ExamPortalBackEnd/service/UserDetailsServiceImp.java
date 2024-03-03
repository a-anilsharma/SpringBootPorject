package com.ExamPortalBackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ExamPortalBackEnd.Entity.User;
import com.ExamPortalBackEnd.repo.UserRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	 
		
		User user= this.userRepository.findByUsername(username);
		if(user==null) {
			
		System.out.println("User dose not exist!!");
		throw new UsernameNotFoundException("User Not found!!");
		}
		
		return user;
	} 
	
	
	

}
