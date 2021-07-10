package kodlama.io.hrms61.entities.concretes;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvert"})
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "city_names")
	private String cityName;
	
   @OneToMany(mappedBy = "city")
   private List<JobAdvert> jobAdvert;

public City(int id, String cityName, List<JobAdvert> jobAdvert) {
	super();
	this.id = id;
	this.cityName = cityName;
	this.jobAdvert = jobAdvert;
}
 public City() {
	 
 }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}
public List<JobAdvert> getJobAdvert() {
	return jobAdvert;
}
public void setJobAdvert(List<JobAdvert> jobadvert) {
	this.jobAdvert = jobadvert;
}
 
 
 
}
