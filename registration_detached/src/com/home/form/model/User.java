package com.home.form.model;

import javax.persistence.Version;
import com.home.form.newdata.entity.UserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class User {

	public User(UserModel userModel) {
		this.name = userModel.getName();
		this.age = userModel.getAge();
	}
	
	private String name;
	private int age;
	@Version
	private Byte version;
}
