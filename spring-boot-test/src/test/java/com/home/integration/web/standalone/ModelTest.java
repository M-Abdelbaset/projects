package com.home.integration.web.standalone;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.home.integration.web.WebController;

class ModelTest {

	MockMvc mockMvc;

	@BeforeEach
	void init() {
		mockMvc = MockMvcBuilders
				.standaloneSetup(new WebController())
				.alwaysExpect(status().isOk())
				.build();
	}
	
	@Test
	void test1() throws Exception {
		mockMvc.perform(get("/web/model"))
		.andExpect(model().attribute("name", is("my name"))).andDo(print());
	}
	
	@Test
	void modelWithErrors() throws Exception {
		
		MultiValueMap<String, String> mvm = new LinkedMultiValueMap<>();
		mvm.add("name", "hello");
		mvm.add("age", "-1");
		
		mockMvc.perform(post("/web/valid")
				.params(mvm)) // we pass params separately to simulate form data. 
		//Otherwise, we wont capture form inputs changes against actual object
		.andExpect(model().hasErrors());
	}
}
