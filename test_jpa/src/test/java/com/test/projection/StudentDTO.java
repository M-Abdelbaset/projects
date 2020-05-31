package com.test.projection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class StudentDTO {

	private Integer id;
	private String name;
	
	public StudentDTO(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + "]";
	}
}
