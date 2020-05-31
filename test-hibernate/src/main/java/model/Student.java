package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "student")
@Cacheable()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student {

	@Id
	private int id;

	@Embedded
	private Name name;

	@Transient
	private int age;

	@OneToOne(fetch = FetchType.LAZY)
	private Laptop laptop;

	@ManyToOne(fetch = FetchType.LAZY)
	private Bus bus;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Book> books = new ArrayList<Book>();
	
	public Student() {}
	
	public Student(Name name, int id) {
		this.name = name;
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int age) {
		this.id = age;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", laptop=" + laptop + ", bus=" + bus
				+ ", books=" + books + "]";
	}
	
}
