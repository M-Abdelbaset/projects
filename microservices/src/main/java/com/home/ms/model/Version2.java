package com.home.ms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Version2 {
	
	private Name name;
	
	@Setter @Getter @AllArgsConstructor @NoArgsConstructor
	public static class Name {
		private String fname;
		private String lname;
	}
}
