package com.ebebek.assignment.configuration;
import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User{
private com.ebebek.assignment.model.User user;
	
	
	public com.ebebek.assignment.model.User  getUser() {
		return user;
	}
	public void setUser(com.ebebek.assignment.model.User  user) {
		this.user = user;
	}

	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}
	
	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,com.ebebek.assignment.model.User user) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, !accountNonLocked, authorities);
		this.user=user;
	}

}