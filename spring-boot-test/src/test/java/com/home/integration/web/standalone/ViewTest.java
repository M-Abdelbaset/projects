package com.home.integration.web.standalone;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.home.integration.web.WebController;

class ViewTest {

	MockMvc mockMvc;
	
	@BeforeEach
	void init() {
		mockMvc = MockMvcBuilders
				.standaloneSetup(new WebController())
				.build();
	}
	
	@Test
	void testRedirect() throws Exception {
		mockMvc.perform(get("/web/redirect"))
		.andExpect(redirectedUrl("dist"));
	}
	
	@Test
	void testForward() throws Exception {
		mockMvc.perform(get("/web/testForward"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("web/model"));
	}
}
