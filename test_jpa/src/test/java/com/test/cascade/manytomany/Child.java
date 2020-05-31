package com.test.cascade.manytomany;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Child")
@Table(name = "child")
@Setter @Getter @NoArgsConstructor
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NaturalId
	private String name;

	private Integer age;

	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "parent_child",
				joinColumns = @JoinColumn(name = "child_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "id"))
	private Set<Parent> parents = new HashSet<>();

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
