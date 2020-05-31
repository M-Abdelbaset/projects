package com.home.integration.web.requestscope;

import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.web.context.annotation.SessionScope;

@SpringJUnitWebConfig(classes = {SessionScopesTest.UserService.class, SessionScopesTest.RequestData.class})
public class SessionScopesTest {

	@Autowired UserService userService;
	@Autowired MockHttpSession session;
	
	@Test
	void testRequest() {
		session.setAttribute("username", "my user name");
		assertEquals("my user name", userService.process());
	}
	
	@Service
	static class UserService {
		@Autowired RequestData requestData;
		
		public String process() {
			return requestData.getData();
		}
	}
	
	@SessionScope @Component
	static class RequestData {
		
		private final HttpSession session;
		
		@Autowired
		public RequestData(HttpSession session) {
			this.session = session;
		}
		
		public String getData() {
			return (String) session.getAttribute("username");
		}
	}
}
