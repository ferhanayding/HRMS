package kodlama.io.hrms61.entities.concretes;


import java.util.List;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvert"})

public class JobTitle {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private int id;

	    @Column(name="title")
	    private String title;
	   
	    
	    @OneToMany(mappedBy = "jobTitle")
	    private List<JobAdvert> jobAdvert;
	    

		public JobTitle(int id, String title,List<JobAdvert> jobAdvert) {
			super();
			
			this.id = id;
			this.title = title;
			this.jobAdvert=jobAdvert;
		}
		public JobTitle() {
			
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		public List<JobAdvert> getJobAdvert() {
			return jobAdvert;
		}
		public void setJobAdvert(List<JobAdvert> jobAdvert) {
			this.jobAdvert = jobAdvert;
		}


	}
	
	

