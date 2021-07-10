 package kodlama.io.hrms61.entities.concretes;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Table(name="candidates")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumes"})	
public class Candidate  extends User{

	@Id
    @Column(name="id")
    private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_Name")
    private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_date")
	private LocalDate birthDay;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Resume> resumes;

	public Candidate(int id, String email, String password, LocalDateTime createdAt, boolean active, int id2,
			String firstName, String lastName, String identityNumber, LocalDate birthDay, List<Resume> resumes) {
		super(id, email, password, createdAt, active);
		id = id2;
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNumber = identityNumber;
		this.birthDay = birthDay;
		this.resumes = resumes;
	}

	public Candidate() {
		
	}

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

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public List<Resume> getResumes() {
		return resumes;
	}

	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}

	

	
	
	
	
}
