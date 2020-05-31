package com.home.security.customauth;

import java.util.List;
import java.util.Map;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	private final Map<String, UserDetails> users;
	
	public CustomUserDetailsService() {
		
		List<GrantedAuthority> userAuth = List.of(new SimpleGrantedAuthority("ROLE_USER"));
		List<GrantedAuthority> adminAuth = List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
		List<GrantedAuthority> managerAuth = List.of(new SimpleGrantedAuthority("ROLE_MANAGER"));
		
		this.users = Map.of(
				"user", User.withUsername("user").password("user123").authorities(userAuth).build(),
				"admin", User.withUsername("admin").password("admin123").authorities(adminAuth).build(),
				"man", User.withUsername("man").password("man123").authorities(managerAuth).build());
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails userDetails = this.users.get(username);
		if(userDetails == null) {
			System.out.println(username + " not found");
			throw new UsernameNotFoundException("Not found");
		} else {
			return userDetails;
		}
	}
}
