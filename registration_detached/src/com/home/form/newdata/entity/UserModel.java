package com.home.form.newdata.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.home.form.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
@Entity(name ="UserModel")
@Table(name = "userModel")
public class UserModel {

	public UserModel(User user) {
		this.name = user.getName();
		this.age = user.getAge();		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NaturalId
	private String name;
	private int age;
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		else if (!(obj instanceof UserModel))
			return false;
		else
			return this.name.equals(((UserModel)obj).getName()) &&
					this.age == (((UserModel)obj).getAge());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
