package com.home.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/holder")
public class SecurityHolderController {

	@GetMapping
	@ResponseBody
	public void getSecurityHolder() {
		
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication authentication = ctx.getAuthentication();
		
		System.out.println(authentication.getName());
		System.out.println(authentication.getCredentials());
		UserDetails UserDetails = (UserDetails) authentication.getPrincipal();
		System.out.println("user details: " + UserDetails.getUsername() + 
				" " + UserDetails.getPassword() + 
				" " + UserDetails.getAuthorities());
	}
}
