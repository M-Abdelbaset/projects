package com.test.cache.secondlevel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Child")
@Table(name = "child")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String name;

	private Integer age;
	
	@OneToMany(mappedBy = "child", 
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER, 
			orphanRemoval = true)
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	private List<Address> addresses = new ArrayList<Address>();
}
