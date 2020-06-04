package com.home.integration.web.standalone;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.SharedHttpSessionConfigurer.sharedHttpSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.home.integration.web.RestfulController;

class SharedSessionTest {
	
	MockMvc mockMvc;
	
	@BeforeEach
	void init() {
		mockMvc = MockMvcBuilders
				.standaloneSetup(new RestfulController())
				.apply(sharedHttpSession())
				.build();
	}
	
	@Test
	void request1() throws Exception {
		
		final String val = "va#1";
		MvcResult result = mockMvc.perform(get("/rest/session/get").sessionAttr("key", val)) // add this attr to the session
				.andExpect(status().isOk())
				.andReturn();
		
		String contentAsString = result.getResponse().getContentAsString();
		Assertions.assertEquals(val, contentAsString);
	}
	
	@Test
	void request2() throws Exception {
		
		final String val = "va#2";
		mockMvc.perform(post("/rest/session/save").content(val)).andExpect(status().isOk());
		
		MvcResult result = mockMvc.perform(get("/rest/session/get"))
				.andExpect(status().isOk())
				.andReturn();
		String contentAsString = result.getResponse().getContentAsString();
		Assertions.assertEquals(val, contentAsString);
	}
}
