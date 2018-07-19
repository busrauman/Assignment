package com.ebebek.assignment.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ebebek.assignment.model.User;
import com.ebebek.assignment.repository.UserRepository;

public class CustomUsernamePasswordAuthenticationFilter extends  UsernamePasswordAuthenticationFilter {
//	@Resource(name = "userRepository")
	@Autowired
	private UserRepository userRepository;
	
	
	public CustomUsernamePasswordAuthenticationFilter(){
		super();
	}
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){
	
 		try{
			
			Authentication auth = super.attemptAuthentication(request,response);
			String username = obtainUsername(request);
			User user = userRepository.findByUsername(username);

			canLoginChecker(user);
			
			return auth;
		}catch (BadCredentialsException e) {
			throw new BadCredentialsException("1"); 
		}
	}
 

	public void canLoginChecker(User kullanici) {
			
		if(kullanici == null){
			throw new BadCredentialsException("1");
		}
	}


	
}
