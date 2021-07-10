package kodlama.io.hrms61.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="employers")
@PrimaryKeyJoinColumn
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvert"})
public class Employer extends User {


	@Id
    @Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	private String webAdress;
	
	@Column(name="phone_number")
	private String phoneNumber;	
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;

	
	public Employer(int id, String email, String password, LocalDateTime createdAt, boolean active, int id2,
			String companyName, String webAdress, String phoneNumber,List<JobAdvert> jobAdverts) {
		super(id, email, password, createdAt, active);
		id = id2;
		this.companyName = companyName;
		this.webAdress = webAdress;
		this.phoneNumber = phoneNumber;
		this.jobAdverts = jobAdverts;
	}
	public Employer() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWebAdress() {
		return webAdress;
	}
	public void setWebAdress(String webAdress) {
		this.webAdress = webAdress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<JobAdvert> getJobAdvert() {
		return jobAdverts;
	}
	public void setJobAdvert(List<JobAdvert> jobAdvert) {
		this.jobAdverts = jobAdvert;
	}
	
	
}
