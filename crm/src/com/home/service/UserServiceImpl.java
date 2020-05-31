package com.home.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.home.dao.CustomerDao;
import com.home.dto.CustomerDTO;
import com.home.dto.CustomerHolder;
import com.home.entity.Customer;
import com.home.exception.CustomerFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	CustomerHolder customerHolder;
	
	@Transactional
	@PreAuthorize("hasRole('USER')")
	public List<CustomerDTO> getCustomers(){
		
		List<Customer> customers = customerDao.getCustomers();
		
		List<CustomerDTO> responseCustomers = new ArrayList<>();
		for(Customer customer : customers) {
			responseCustomers.add(new CustomerDTO(customer));
		}
		
		return responseCustomers;
	}

	@Transactional
	@PreAuthorize("isAnonymous() || hasRole('MANAGER')") // only new users or managers can register
	public void registerCustomer(CustomerDTO customerDto) {
		
		String email = customerDto.getEmail();
		Customer customer = customerDao.getCustomer(email);
		if(customer != null) {
			throw new CustomerFoundException("customer with email: " + email + " already exists!");
		}
		
		String encodedPassword = encoder.encode(customerDto.getPassword());
		Customer customerEntity = new Customer(customerDto);
		customerEntity.setPassword(encodedPassword);
		customerDao.saveCustomer(customer);
	}

	@Transactional
	@PreAuthorize("hasRole('MANAGER')")
	public CustomerDTO getCustomer(String email) {
		
		Customer customer = customerDao.getCustomer(email);
		customerHolder.setCustomer(customer);
		
		return new CustomerDTO(customer);
	}
	
	@Transactional
	@PreAuthorize("hasRole('MANAGER')")
	public void updateCustomer(CustomerDTO customerDto) {
		
		Customer customer = customerHolder.getCustomer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		
		customerDao.updateCustomer(customer);
	}

	@Transactional
	@PreAuthorize("hasRole('MANAGER')")
	public void deleteCustomer(String email) {
		customerDao.deleteCustomer(email);
	}
}
