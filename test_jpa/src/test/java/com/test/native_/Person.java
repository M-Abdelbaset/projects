package com.test.native_;

import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SqlResultSetMappings({
	@SqlResultSetMapping(name = "genderPerson", entities = {
			@EntityResult(entityClass = com.test.native_.Person.class, fields = {
					@FieldResult(name = "id", column = "ID"),
					@FieldResult(name = "gender", column = "GENDER"),
					@FieldResult(name = "name", column = "NAME"),
					@FieldResult(name = "status", column = "MART_STATUS")
				}
			)
		}
	),
	@SqlResultSetMapping(name = "join", entities = {
			@EntityResult(entityClass = com.test.native_.Person.class, fields = {
					@FieldResult(name = "id", column = "ID"),
					@FieldResult(name = "gender", column = "GENDER"),
					@FieldResult(name = "name", column = "NAME"),
					@FieldResult(name = "status", column = "MART_STATUS")
				}
			)
		}
	)
})
@NamedNativeQuery(
    name = "PostDTO",
    query = "select p.name as name, p.gender as gender from person p where p.id=:id",
    resultSetMapping = "PersonDTO"
)
@SqlResultSetMapping(
    name = "PersonDTO",
    classes = @ConstructorResult(
        targetClass = PersonDTO.class,
        columns = {
            @ColumnResult(name = "name"),
            @ColumnResult(name = "gender")
        }
    )
)
@Entity(name = "Person")
@Table(name = "person")
@Setter @Getter @NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String status;
	private String gender;
	
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Laptop laptop;
	
	public Person(String name, String status, String gender, Laptop laptop) {
		this.name = name;
		this.status = status;
		this.gender = gender;
		this.laptop = laptop;
		laptop.setPerson(this);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", status=" + status + ", gender=" + gender + ", laptop="
				+ laptop + "]";
	}
}
