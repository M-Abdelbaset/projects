package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop {
	
	@Id
	private int id;
	private String type;

	@OneToOne
	private Student std;
	
	public Laptop() {}
	
	public Laptop(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}
}
