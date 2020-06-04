package com.home.integration.web.standalone;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.home.integration.web.RestfulController;
import com.home.integration.web.ServiceImpl;

@ExtendWith(MockitoExtension.class)
class StandaloneTest {

	MockMvc mockMvc;
	
	@Mock ServiceImpl serviceImpl;
	
	@InjectMocks RestfulController restfulController;
	
	@BeforeEach
	void init() {
		mockMvc = MockMvcBuilders
				.standaloneSetup(restfulController)
				.build();
	}
	
	@Test
	void test() throws Exception {
		
		when(serviceImpl.get()).thenReturn("xyz");
		
		mockMvc.perform(get("/rest/json")
				.queryParam("key", "Ali")
		 .accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.xyz").value("Ali"));
	}
}
