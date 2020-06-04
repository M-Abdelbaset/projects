package com.home.integration.web.springtestmockApi;

import javax.servlet.http.HttpServletRequest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.web.context.annotation.RequestScope;

@SpringJUnitWebConfig(classes = {RequestScopesTest.UserService.class, RequestScopesTest.RequestData.class})
class RequestScopesTest {

	@Autowired UserService userService;
	@Autowired MockHttpServletRequest request;
	
	@Test
	void testRequest() {
		request.addParameter("username", "my user name");
		assertEquals("my user name", userService.process());
	}
	
	@Service
	static class UserService {
		@Autowired RequestData requestData;
		
		public String process() {
			return requestData.getData();
		}
	}
	
	@RequestScope @Component
	static class RequestData {
		
		private final HttpServletRequest request;
		
		@Autowired
		public RequestData(HttpServletRequest request) {
			this.request = request;
		}
		
		public String getData() {
			return request.getParameter("username");
		}
	}
}
