package com.test.native_;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter @Getter @NoArgsConstructor
public class PersonDTO {

	private String name;
	private String gender;
	
	public PersonDTO(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "PersonDTO [name=" + name + ", gender=" + gender + "]";
	}
}
