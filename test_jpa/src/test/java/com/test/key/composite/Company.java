package com.test.key.composite;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Company")
@Table(name = "company")
@Setter @Getter
@NoArgsConstructor
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 

	private String name;

	public Company(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Company))
			return false;
		else {
			Company that = (Company) obj;
			return Objects.equals(that.getId(), this.id) &&
					Objects.equals(that.getName(), this.name);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
