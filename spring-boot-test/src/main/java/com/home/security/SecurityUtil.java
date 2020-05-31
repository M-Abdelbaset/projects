package com.home.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

	public static boolean isAnonymous() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(authentication.getAuthorities());

		return authorities.size() == 1 && authorities.get(0).getAuthority().equals("ROLE_ANONYMOUS");
	}
}
