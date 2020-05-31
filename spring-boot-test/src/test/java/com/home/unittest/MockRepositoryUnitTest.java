package com.home.unittest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.home.dao.CustomerDao;
import com.home.dto.CustomerDTO;
import com.home.entity.Customer;
import com.home.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class MockRepositoryUnitTest {

	@Mock
	private CustomerDao customerDao;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Test
	void testGetAllCustomers() {
		
		// setup
		List<Customer> dbCustomersList = List.of(
				new Customer().firstName("ahmed").lastName("mohamed").email("ahmed@email.com").password("xed"),
				new Customer().firstName("rana").lastName("hady").email("rana@email.com").password("tfg"),
				new Customer().firstName("hisham").lastName("jyed").email("hisham@email.com").password("qws")
		);
		
		when(customerDao.getCustomers()).thenReturn(dbCustomersList);
		
		// run
		java.util.List<CustomerDTO> customerDtoList = userServiceImpl.getCustomers();

		// verify
		verify(customerDao, times(1)).getCustomers();
		assertThat(dbCustomersList.size(), is(customerDtoList.size()));
		
		List<CustomerDTO> expectedCustomersDtoList = List.of(
				new CustomerDTO().firstName("ahmed").lastName("mohamed").email("ahmed@email.com"),
				new CustomerDTO().firstName("rana").lastName("hady").email("rana@email.com"),
				new CustomerDTO().firstName("hisham").lastName("jyed").email("hisham@email.com")
		);
		
		assertIterableEquals(expectedCustomersDtoList, customerDtoList);
	}
}