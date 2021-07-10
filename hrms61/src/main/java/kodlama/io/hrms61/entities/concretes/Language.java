package kodlama.io.hrms61.entities.concretes;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name="languages")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "languageLevel"})
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity=Resume.class, fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="resume_id", referencedColumnName="id", nullable=false)
	private Resume resume;
	
	@CreationTimestamp
//	@JsonIgnore
	@Column(name="created_date")
	private Date createdDate;
	
	@UpdateTimestamp
//	@JsonIgnore
	@Column(name="update_date")
	private Date updateDate;
	
	@ManyToOne(targetEntity = LanguageLevel.class)
	@JoinColumn(name="language_level_id")
	private LanguageLevel languageLevel;
	
	@ManyToOne(targetEntity = LanguageList.class)
	@JoinColumn(name="language_list_id")
	private LanguageList languageList;

	public Language(int id, Resume resume, Date createdDate, Date updateDate,LanguageLevel languageLevel, 
			LanguageList languageList) {
		super();
		this.id = id;
		this.resume = resume;
		this.createdDate = createdDate;
		this.updateDate = updateDate;
		this.languageLevel = languageLevel;
		this.languageList = languageList;
	}
	public Language() {
		
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
	public LanguageLevel getLanguageLevel() {
		return languageLevel;
	}
	public void setLanguageLevel(LanguageLevel languageLevel) {
		this.languageLevel = languageLevel;
	}
	public LanguageList getLanguageList() {
		return languageList;
	}
	public void setLanguageList(LanguageList languageList) {
		this.languageList = languageList;
	}
}
