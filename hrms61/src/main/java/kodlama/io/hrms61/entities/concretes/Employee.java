package kodlama.io.hrms61.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity 

@Table(name="employees")
@PrimaryKeyJoinColumn
public class Employee extends User {
	
    @Id
    @Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Employee(int id, String email, String password, LocalDateTime createdAt, boolean active, int id2,
			String firstName, String lastName) {
		super(id, email, password, createdAt, active);
		id = id2;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee() {}
	
	
}
