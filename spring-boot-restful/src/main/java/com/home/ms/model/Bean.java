package com.home.ms.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@JsonIgnoreProperties(value = {"field3"})
@JsonInclude(value = Include.NON_NULL)
public class Bean {
	
	@JsonIgnore
	private String field1;
	private String field2;
	private String field3;
	private NestedBean nestedBean;
	private NestedBean2 nestedBean2;
	
	@JsonIgnoreType
	@AllArgsConstructor @NoArgsConstructor @Setter @Getter
	public static class NestedBean {

		private String field4;
		private String field5;
	}

	@AllArgsConstructor @NoArgsConstructor @Setter @Getter
	@JsonFilter("nestedBean2")
	public static class NestedBean2 {

		private String field6;
		private String field7;
		private String field8;
	}

}