	package kodlama.io.hrms61.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="educations")
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id" )		
	private Resume resume;
	
	

	@ManyToOne(targetEntity=EducationLevel.class, fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="education_level_id", referencedColumnName="id", nullable=false)	
	private EducationLevel educationLevel;
	
	
	@Column(name="school_name")
	@NotBlank(message="Boş geçilemez")
	private String schoolName;
	
	
	@Column(name="department_name")
	private String departmentName;


	@Column(name="started_date")
	private Date startedDate;
	
	@Column(name="ended_date")
	private Date endedDate;
			
	@CreationTimestamp
//	@JsonIgnore
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
//	@JsonIgnore
	@Column(name="update_date")
	private LocalDateTime updateDate;

	public Education(int id, Resume resume, EducationLevel educationLevel,
			String schoolName, String departmentName, Date startedDate,
			Date endedDate, LocalDateTime createdDate, LocalDateTime updateDate) {
		super();
		this.id = id;
		this.resume = resume;
		this.educationLevel = educationLevel;
		this.schoolName = schoolName;
		this.departmentName = departmentName;
		this.startedDate = startedDate;
		this.endedDate = endedDate;
		this.createdDate = createdDate;
		this.updateDate = updateDate;
	}
	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public EducationLevel getEducationLevel() {
		return educationLevel;
	}
	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Date getStartedDate() {
		return startedDate;
	}
	public void setStartedDate(Date startedDate) {
		this.startedDate = startedDate;
	}
	public Date getEndedDate() {
		return endedDate;
	}
	public void setEndedDate(Date endedDate) {
		this.endedDate = endedDate;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
