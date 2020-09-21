package com.home.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.home.jwt.model.JwtResponse;
import com.home.jwt.model.User;
import com.home.jwt.util.JwtUtil;

@RestController
public class HomeController {

	@Autowired AuthenticationManager authenticationManager;
	
	@GetMapping("/home")
	public String ssl() {
		return "Home";
	}
	
	@PostMapping("/authorize")
	public JwtResponse authenticate(@RequestBody User user) {
		
		authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		return new JwtResponse(JwtUtil.createToken(user.getUsername()));
	}
}
