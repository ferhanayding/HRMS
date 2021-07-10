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
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="technologies")
public class Tech {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		@Column(name="id")
		private int id;
		
		@ManyToOne(targetEntity = Resume.class)
		@JoinColumn(name="resume_id", referencedColumnName="id", nullable=false)
		private Resume resume;
		
		@Column(name="technology_name")
		@NotBlank(message="boş geçilemez")
		private String technologyName;
		
		@CreationTimestamp
//		@JsonIgnore
		@Column(name="created_date")
		private Date createDate;
		
		@UpdateTimestamp
//		@JsonIgnore
		@Column(name="update_date")
		private Date updateDate;
		
		public Tech(int id, Resume resume, @NotBlank(message = "boş geçilemez") String technologyName, Date createDate,
				Date updateDate) {
			super();
			this.id = id;
			this.resume = resume;
			this.technologyName = technologyName;
			this.createDate = createDate;
			this.updateDate = updateDate;
		}
		public Tech() {
			
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
		public String getTechnologyName() {
			return technologyName;
		}
		public void setTechnologyName(String technologyName) {
			this.technologyName = technologyName;
		}
		public Date getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
		public Date getUpdateDate() {
			return updateDate;
		}
		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}

	
}
