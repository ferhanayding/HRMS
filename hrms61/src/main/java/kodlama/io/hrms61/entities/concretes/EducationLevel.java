package kodlama.io.hrms61.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="education_level")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "educations"})
public class EducationLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="level_name")
	@NotBlank(message = "Bu alan boş bırakılamaz")	
	private String levelName;
	
//	@JsonIgnore	
	@OneToMany(mappedBy = "educationLevel")	
	private List<Education> educations;
	
public EducationLevel(int id, @NotBlank(message = "Bu alan boş bırakılamaz") String levelName,
			List<Education> educations) {
		super();
		this.id = id;
		this.levelName = levelName;
		this.educations = educations;
	}

public EducationLevel() {
	super();
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getLevelName() {
	return levelName;
}

public void setLevelName(String levelName) {
	this.levelName = levelName;
}

public List<Education> getEducations() {
	return educations;
}

public void setEducations(List<Education> educations) {
	this.educations = educations;
}

	
}
