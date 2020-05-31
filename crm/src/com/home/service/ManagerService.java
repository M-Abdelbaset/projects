package com.home.service;

import com.home.dto.CustomerDTO;

public interface ManagerService {

	void updateCustomer(CustomerDTO customer);
	void deleteCustomer(CustomerDTO customer);
}
