package com.ExamPortalBackEnd.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.Principal;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ExamPortalBackEnd.Entity.JwtRequest;
import com.ExamPortalBackEnd.Entity.JwtResponse;
import com.ExamPortalBackEnd.Entity.User;
import com.ExamPortalBackEnd.config.JwtUtil;
import com.ExamPortalBackEnd.service.UserDetailsServiceImp;
import com.ExamPortalBackEnd.service.UserService;

@CrossOrigin(origins ={"http://localhost:4200","http://localhost:4201"}  ,maxAge = 3600,
methods = {RequestMethod.GET,RequestMethod.POST} ,allowedHeaders="*",exposedHeaders ="*")
@RestController
public class AuthenticateController {
	
	  @Autowired
	  private UserDetailsService userDetailsService;

	    @Autowired
	    private AuthenticationManager manager;


	    @Autowired
	    private JwtUtil jwtUtil;
	  	 @PostMapping("/generate-token")
	    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

	        this.doAuthenticate(request.getUsername(), request.getPassword());


	        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
	        String token = this.jwtUtil.generateToken(userDetails);
	        System.out.println("Token:--->"+token);

//	        JwtResponse response = JwtResponse.builder()
//	                .jwtToken(token)
//	                .username(userDetails.getUsername()).build(); 
	        return ResponseEntity.ok(new JwtResponse(token));
	    }

	    private void doAuthenticate(String username, String password) {
	    	System.out.println("Username-->"+username+" Password-->"+password);

	        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
	        try {
	            manager.authenticate(authentication);


	        } catch (BadCredentialsException e) {
	            throw new BadCredentialsException(" Invalid Username or Password  !!");
	        }

	    }

	    @ExceptionHandler(BadCredentialsException.class)
	    public String exceptionHandler() {
	        return "Credentials Invalid !!";
	    }

	    @CrossOrigin("*")
	    @GetMapping("/current-user")
	    public User getCurrentUser(Principal principal) {
	    	
	    	return (User)this.userDetailsService.loadUserByUsername(principal.getName());
	    }
	    		

	}







   




