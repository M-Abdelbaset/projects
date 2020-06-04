package com.home.ms.rs;

import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.home.ms.model.Bean;
import com.home.ms.model.Bean.NestedBean;
import com.home.ms.model.Bean.NestedBean2;

@RestController
@RequestMapping(path = "/filter")
public class PropertyFilter {

	@GetMapping
	public List<Bean> filterBeans(){
		return List.of(
				new Bean("value11", "value21", "value31", new NestedBean("value41", "value51"), new NestedBean2("value61", "value71", "value81")),
				new Bean("value12", "value22", "value32", new NestedBean("value42", "value52"), new NestedBean2("value61", "value71", "value81"))
		);
	}
	
	@GetMapping(path = "/dynamic")
	public ResponseEntity<MappingJacksonValue> filterBeansDynamic(){
		
		List<Bean.NestedBean2> beans = List.of(
				new NestedBean2("value61", "value71", "value81"),
				new NestedBean2("value61", "value71", "value81")
		);

		return new ResponseEntity<MappingJacksonValue>(
						createFilter("nestedBean2", beans, Set.of("field7")), HttpStatus.CREATED);
	}
	
	private static MappingJacksonValue createFilter(
			String filterName, 
			Object filteredData,
			Set<String> pass) {
		
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept(pass);
		
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter(filterName, filter);
		
		MappingJacksonValue value = new MappingJacksonValue(filteredData);
		value.setFilters(filters);
		
		return value;
	}
}
