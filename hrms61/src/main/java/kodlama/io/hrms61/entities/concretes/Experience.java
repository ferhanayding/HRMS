package kodlama.io.hrms61.entities.concretes;

import java.sql.Date;
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
@Table(name="experiences")
public class Experience {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity=Resume.class, fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	@NotBlank(message="Boş geçilemez")
	@Column(name="company_name")
	private String companyName;
	
	
	@NotBlank(message="Boş geçilemez")
	@Column(name="position")
	private String position;
	
	
	@NotBlank(message="Boş geçilemez")
	@Column(name="started_at")
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

	public Experience(int id, Resume resume, @NotBlank(message = "Boş geçilemez") String companyName,
			@NotBlank(message = "Boş geçilemez") String position,
			@NotBlank(message = "Boş geçilemez") Date startedDate, Date endedDate, LocalDateTime createdDate, LocalDateTime updateDate) {
		super();
		this.id = id;
		this.resume = resume;
		this.companyName = companyName;
		this.position = position;
		this.startedDate = startedDate;
		this.endedDate = endedDate;
		this.createdDate = createdDate;
		this.updateDate = updateDate;
	}
	public Experience() {
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosition() {
		return position;
	}

	public void setPositionName(String position) {
		this.position = position;
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
