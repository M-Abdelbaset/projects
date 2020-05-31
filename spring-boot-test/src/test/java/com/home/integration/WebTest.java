package com.home.integration;

import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringJUnitWebConfig
public class WebTest {

	@Autowired MockHttpServletRequest request;
	
	@Test
	void test() {
		assertThat(request, notNullValue());
	}
}
