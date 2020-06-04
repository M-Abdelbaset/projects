package com.home.integration.web.standalone;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.home.integration.web.RestfulController;

public class XMLTest {

	MockMvc mockMvc;

	@BeforeEach
	void init() {
		mockMvc = MockMvcBuilders
				.standaloneSetup(new RestfulController())
				.alwaysExpect(status().isOk())
				.build();
	}
	
	@Test
	void test1() throws Exception {
		mockMvc.perform(get("/rest/xml")).andDo(print())
		.andExpect(xpath("Person/age").string("111"));
	}
}
