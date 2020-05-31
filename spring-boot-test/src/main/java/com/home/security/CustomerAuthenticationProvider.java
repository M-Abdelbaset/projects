package com.home.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomerAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		final String suffix = "@yahoo.com";
		
		String username = authentication.getName();
		username = username.contains(suffix) ? username : username + suffix;
		
		String password = authentication.getCredentials().toString();
		password = password.contains(suffix) ? password : password + suffix;
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				
		boolean matches = encoder.matches(password, userDetails.getPassword());
		
		if(!matches)
			throw new BadCredentialsException("Bad credentials!");
		
		return new UsernamePasswordAuthenticationToken(
				userDetails, 
				authentication.getCredentials(), 
				userDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
