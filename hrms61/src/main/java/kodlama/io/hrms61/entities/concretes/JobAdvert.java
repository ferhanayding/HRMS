package kodlama.io.hrms61.entities.concretes;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="job_adverts")
public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "descriptions")
	private String jobDescription;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "open_positions")
	private int OpenPosition;

	@CreationTimestamp
	@Column(name="created_at")
    private Date createdAt;
	
   @Column(name="active", columnDefinition = "boolean default true")
   private boolean active;
  
   
//   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "application_deadlinies")
	private Date applicationDeadline;
   
//   ilişkiler 
   @ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	public JobAdvert(int id, String jobDescription, int minSalary, int maxSalary, int openPosition,
			Date createdAt, boolean active,Date applicationDeadline, JobTitle jobTitle, City city,
			Employer employer) {
		super();
		this.id = id;
		this.jobDescription = jobDescription;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		OpenPosition = openPosition;
		this.createdAt = createdAt;
		this.active = active;
		this.applicationDeadline = applicationDeadline;
		this.jobTitle = jobTitle;
		this.city = city;
		this.employer = employer;
	}

	public JobAdvert() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}

	public int getOpenPosition() {
		return OpenPosition;
	}

	public void setOpenPosition(int openPosition) {
		OpenPosition = openPosition;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
   
   
   
   
   

}
