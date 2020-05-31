package com.home.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jws.WebService;

import com.home.model.CustomType;

@WebService(endpointInterface = "com.home.service.IProductCategory", 
serviceName = "martService", portName = "martPort")
public class ProductCategory implements IProductCategory {

	private Set<String> categories = new HashSet<>(Set.of("Books", "Music"));

	@Override
	public Set<CustomType> getCategories() {
		return Set.of(new CustomType("one", 1), new CustomType("two", 2));
	}

	@Override
	public CustomType addCategories(String category, CustomType customType) throws CustomException{
		if(category.isEmpty())
			throw new CustomException("Error in add categories", "Empty category", "110");
		categories.add(category);
		
		
		
		return null;
	}
	
	private void test(List<? extends String> list1, List<? super String> list2) {
		Object object = list2.get(1);
		String string = list1.get(0);
	}
}
