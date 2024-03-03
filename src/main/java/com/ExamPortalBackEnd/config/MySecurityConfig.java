package com.ExamPortalBackEnd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.ExamPortalBackEnd.service.UserService;
import com.ExamPortalBackEnd.service.UserServiceImpl;


@EnableWebSecurity
@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {
	

    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
        //.cors(cors->cors.disable())
        .authorizeRequests(auth->auth.requestMatchers("/generate-token","/current-user","/user/","/category/","/quiz/*").permitAll().anyRequest().authenticated())
             //   requestMatchers("/test").authenticated().requestMatchers("/generate-token").permitAll()
                //.anyRequest()
                //.authenticated()
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
//
//	@Autowired
//	 private JwtAuthenticationFilter jwtAuthenticationFilter;
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	private JwtAuthenticationEntryPoint unauthorizedHandler;
//	
//
//    @SuppressWarnings("removal")
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception  {
//     System.out.println("in filter");
//     http.csrf(AbstractHttpConfigurer::disable)
//     .authorizeHttpRequests(request -> request.requestMatchers("/generate-token").permitAll()
//    		 .anyRequest().authenticated())
//     .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//     .authenticationProvider(authenticationProvider()).addFilterBefore(
//             jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//return http.build();
////     
////        		  http.authorizeHttpRequests()
////        		  .requestMatchers("/generate-token").permitAll()
////        		  .anyRequest().authenticated()
////        		  .and() 
////        		  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////        		  .and()
////        		  
////	                .addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
////        		 .authenticationProvider(authenticationProvider());
////        		  
//        
//    }
//
    @Bean
    PasswordEncoder passwordEncoder() {
        return  NoOpPasswordEncoder.getInstance();
    }

    @Bean
   public AuthenticationManager AuthenticationManager(AuthenticationConfiguration config)
            throws Exception {
    	System.out.println("AuthenticationManager function config file");
        return config.getAuthenticationManager();
    }
//	   
//    @Bean
//     public AuthenticationProvider authenticationProvider() {
//    	System.out.println("authenticationProvider file");
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(this.userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }

	
}
