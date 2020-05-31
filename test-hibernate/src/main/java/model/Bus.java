package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus {

	@Id
	private int id;
	private String route;

	@OneToMany(mappedBy = "bus")
	private List<Student> stds;

	public Bus() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Bus(int id, String route, List<Student> stds) {
		super();
		this.id = id;
		this.route = route;
		this.stds = stds;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public List<Student> getStds() {
		return stds;
	}

	public void setStds(List<Student> stds) {
		this.stds = stds;
	}

}
