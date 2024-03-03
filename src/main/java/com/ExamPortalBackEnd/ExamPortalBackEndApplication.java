package com.ExamPortalBackEnd;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ExamPortalBackEnd.Entity.Role;
import com.ExamPortalBackEnd.Entity.User;
import com.ExamPortalBackEnd.Entity.UserRole;
import com.ExamPortalBackEnd.service.UserService;
import com.ExamPortalBackEnd.service.UserServiceImpl;

@SpringBootApplication
public class ExamPortalBackEndApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalBackEndApplication.class, args);
		System.out.println("Started");
		
		   
		
	}

  
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Code Started....");
//		User user= new User();
//		user.setFirstname("Anu");
//		user.setLastname("Sharma");
//		user.setUsername("Anu1998");
//		user.setPassword(bCryptPasswordEncoder.encode("xyz") );
//		user.setEmail("Anu@gmail.com");
//		user.setProfile("default.png");
//		
//		Role role1 =new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//		 
//		Set<UserRole> userRolesSet= new HashSet<>();
//		
//	   UserRole userRole= new UserRole();
//	   userRole.setRole(role1);
//	   userRole.setUser(user);
//	   
//	   userRolesSet.add(userRole);
//	
//		this.userService.createUser(user, userRolesSet);
	}
	
	

}
