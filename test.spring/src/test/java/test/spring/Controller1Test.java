package test.spring;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class Controller1Test {

	@InjectMocks
	Controller1 c;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		// this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(c).build();
	}

	@Test
	@Ignore
	public void whenIdPathVariableIsPassed_thenResponseOK() throws Exception {

		int articleId = 5;

		MvcResult res = this.mockMvc.perform(MockMvcRequestBuilders.get("/articleOpt/{id}", articleId))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		System.out.println("result: " + res.getResponse().getContentAsString());
	}
	
	@Test
	public void whenIdPathVariableIsPassed_thenResponseOK2() throws Exception {

		int articleId = 5;

		MvcResult res = this.mockMvc.perform(MockMvcRequestBuilders.get("/articleMap/{id}", articleId))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		System.out.println("result: " + res.getResponse().getContentAsString());
	}

	
}
