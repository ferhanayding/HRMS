package kodlama.io.hrms61.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="language_level")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "language"})
public class LanguageLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="level")
	private String level;

	@JsonIgnore
	@OneToMany(mappedBy = "languageLevel")
	private List<Language> languages;

	public LanguageLevel(int id, String level, List<Language> languages) {
		super();
		this.id = id;
		this.level = level;
		this.languages = languages;
	}
	public LanguageLevel() {
		super();
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<Language> getLanguage() {
		return languages;
	}

	public void setLanguage(List<Language> languages) {
		this.languages = languages;
	}

	
}
