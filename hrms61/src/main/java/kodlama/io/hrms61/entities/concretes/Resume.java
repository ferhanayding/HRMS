package kodlama.io.hrms61.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="resumes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations", "experiences", "languages", "technologies"})
public class Resume {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity=Candidate.class)	
	@JoinColumn(name="candidate_id", referencedColumnName="id", nullable=false)
	private Candidate candidate;
	
	@Column(name="summary")
	private String summary;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="about_yourself")
	private String aboutYourself;
	
	@Column(name="hobbies")
	private String hobbies;
	
	@CreationTimestamp
	@JsonIgnore
	@Column(name="created_date")
	private Date createdDate;
	
	@UpdateTimestamp
	@JsonIgnore
	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="is_active") 
//	@JsonIgnore
	private boolean isActive=true;
	
//	 fetch = FetchType.LAZY
	@JsonIgnore
	@OneToMany(mappedBy = "resume") 							
	private List<Education> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")							
	private List<Experience> experiences;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")							
	private List<Language> languages;
	

	@JsonIgnore
	@OneToMany(mappedBy = "resume")							
	private List<Tech> technologies;
	
	public Resume(int id, Candidate candidate, String summary, String githubLink, String linkedinLink, String photo,
			Date createdDate, Date updateDate, boolean isActive, List<Education> educations,
			List<Experience> experiences, List<Language> languages, List<Tech> technologies,String aboutYourself,String hobbies) {
		super();
		this.id = id;
		this.candidate = candidate;
		this.summary = summary;
		this.githubLink = githubLink;
		this.linkedinLink = linkedinLink;
		this.photo = photo;
		this.createdDate = createdDate;
		this.updateDate = updateDate;
		this.isActive = isActive;
		this.educations = educations;
		this.experiences = experiences;
		this.languages = languages;
		this.technologies = technologies;
	}

	public String getAboutYourself() {
		return aboutYourself;
	}

	public void setAboutYourself(String aboutYourself) {
		this.aboutYourself = aboutYourself;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public Resume() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getGithubLink() {
		return githubLink;
	}

	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}

	public String getLinkedinLink() {
		return linkedinLink;
	}

	public void setLinkedinLink(String linkedinLink) {
		this.linkedinLink = linkedinLink;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<Tech> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Tech> technologies) {
		this.technologies = technologies;
	}
}
