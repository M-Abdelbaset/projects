package com.home.integration.web.standalone;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.home.integration.web.WebController;

class FlashTest {

	MockMvc mockMvc;
	
	@BeforeEach
	void init() {
		mockMvc = MockMvcBuilders
				.standaloneSetup(new WebController())
				.build();
	}
	
	@Test
	void testFlash() throws Exception {
		mockMvc.perform(get("/web/redirect"))
		.andExpect(status().is3xxRedirection())
		.andExpect(flash().attribute("attr", "hello"));
	}
	
	@Test
	void testFlash2() throws Exception {
		mockMvc.perform(get("/web/dist").flashAttr("attr", "hello"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("attr", "hello"));
	}
}
