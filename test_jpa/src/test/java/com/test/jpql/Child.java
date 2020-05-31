package com.test.jpql;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Child")
@Table(name = "child")
@Setter
@Getter
@NoArgsConstructor
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, updatable = false)
	private String name;

	private Integer age;
	
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Parent parent;

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		else if (!(obj instanceof Child))
			return false;
		else {
			Child that = (Child) obj;
			return Objects.equals(this.name, that.getName());
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
