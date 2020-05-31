package com.home.service;

import java.util.HashSet;
import java.util.Set;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Product {
	
	private Set<String> products = new HashSet<>(Set.of("java", "c++"));
	
	@WebMethod
	public Set<String> getProducts() {
		return products;
	}
}
