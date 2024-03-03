package com.ExamPortalBackEnd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamPortalBackEnd.Entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{

	public User findByUsername(String username);
	
	//public String deleteUserByUsername(String username);
}
