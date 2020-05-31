package com.home.service;

import java.util.List;

import com.home.dto.CustomerDTO;

public interface UserService {

	public List<CustomerDTO> getCustomers();
	public CustomerDTO getCustomer(String email);
	public void registerCustomer(CustomerDTO customer);
	void updateCustomer(CustomerDTO customer);
    void deleteCustomer(String email);
}