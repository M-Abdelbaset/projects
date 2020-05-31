package com.home.security.customauth;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomUserDetailsService service;
	
	@Override
	public Authentication authenticate(Authentication authentication) 
			throws AuthenticationException {
		
		//request credentials
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		// saved credentials and roles
		UserDetails user = service.loadUserByUsername(username);
		String savedPassword = user.getPassword();
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		
		if(passwordEncoder.matches(password, savedPassword)) {
			return new UsernamePasswordAuthenticationToken(
					user, authentication.getCredentials(), authorities);
		} else {
			throw new BadCredentialsException("Failed to authenticate: " + username);
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
