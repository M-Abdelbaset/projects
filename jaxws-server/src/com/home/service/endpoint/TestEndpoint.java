package com.home.service.endpoint;

import javax.xml.ws.Endpoint;
import com.home.service.ProductCategory;

public class TestEndpoint {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:7485/test/productCategory", new ProductCategory());
	}
}
