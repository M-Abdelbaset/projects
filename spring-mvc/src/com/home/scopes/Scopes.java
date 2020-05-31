package com.home.scopes;

import java.util.Iterator;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/scopes")
public class Scopes {

	@Autowired
	private RequestScopeBean requestScopeBean;
	
	@Autowired
	private SessionScopeBean sessionScopeBean;
	
	@Autowired
	private ApplicationScopeBean appScopeBean;
	
	@Autowired
	private ServletContext context; 
	
	@GetMapping(path = "/request")
	@ResponseBody
	public void testRequestScopes() {
		System.out.println(requestScopeBean.toString());
	}
	
	@GetMapping(path = "/session")
	@ResponseBody
	public void testSessionScopes() {
		System.out.println(sessionScopeBean.toString());
	}
	
	@GetMapping(path = "/app")
	@ResponseBody
	public void testApplicationScopes() {
		Iterator<String> it = context.getAttributeNames().asIterator();
		while(it.hasNext())
			System.out.println(it.next() + ", ");
		System.out.println();
		System.out.println(appScopeBean.toString());
	}
}
