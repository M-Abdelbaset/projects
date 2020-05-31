package com.home.security;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.home.dao.CustomerDao;
import com.home.entity.Customer;

@Service
public class UserDetailsImpl implements UserDetailsService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Customer customer = customerDao.getCustomer(email);
		
		if(customer == null)
			throw new UsernameNotFoundException(email + " not found!");
		
		return new User(
				customer.getEmail(), 
				customer.getPassword(), 
				List.of(new SimpleGrantedAuthority(customer.getAuthority())));
	}

}
