package com.test.merge;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Address")
@Table(name = "address")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Address {

	@Id
	private Integer id;
	private String address;
	@Version
	private Integer version;
}
