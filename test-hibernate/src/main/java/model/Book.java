package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	private int id;
	private int name;

	public Book() {}
	
	public Book(int id, int name, List<Student> stds) {
		this.id = id;
		this.name = name;
		this.stds = stds;
	}

	@ManyToMany(mappedBy = "books")
	private List<Student> stds;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public List<Student> getStds() {
		return stds;
	}

	public void setStds(List<Student> stds) {
		this.stds = stds;
	}
}
