package com.test.native_;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Laptop")
@Table(name = "laptop")
@Setter @Getter @NoArgsConstructor
public class Laptop {
	
	@Id
	private Integer id;
	
	private String model;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private Person person;

	public Laptop(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", model=" + model + "]";
	}
}
