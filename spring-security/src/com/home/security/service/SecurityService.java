package com.home.security.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

	@PreAuthorize("hasRole('ADMIN')") // need to use @EnableGlobalMethodSecurity first!
	@PostFilter("filterObject == principal.username")
	public List<String> access() {
		return new ArrayList<String>(List.of("user", "admin", "man"));
	}
}
