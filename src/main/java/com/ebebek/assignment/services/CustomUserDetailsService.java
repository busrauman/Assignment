package com.ebebek.assignment.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebebek.assignment.configuration.CustomUser;
import com.ebebek.assignment.model.User;
import com.ebebek.assignment.repository.UserRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
    
	@Autowired
	private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Username not found"); 
		}
		
		
		return new CustomUser(user.getUsername() , user.getPassword(), 
				true, true, true, false, getAuthorities(user), user);
    }
	
	private  List<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(null != user) {
			authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
		}
        return authorities;
    }

	public void saveUser(User user) {
		 user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        userRepository.save(user);
	}
	
}