package com.home.integration.web.fullcontext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.home.integration.web.AbstractWebTest;

@SpringJUnitWebConfig
class FullWebTest extends AbstractWebTest {
	
	MockMvc mockMvc;
	@Autowired WebApplicationContext context;
	
	@BeforeEach
	void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	void test() throws Exception {
		
		mockMvc.perform(get("/rest/json")
				.queryParam("key", "Ali")
		 .accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.val").value("Ali"));
	}
}
