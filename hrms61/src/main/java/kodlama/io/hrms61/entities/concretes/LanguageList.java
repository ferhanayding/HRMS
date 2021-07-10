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
@Table(name="language_lists")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "languages"})
public class LanguageList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="language_name")
	private String languageName;

	@OneToMany(mappedBy = "languageList")
	private List<Language> languages;

	public LanguageList(int id, String languageList, List<Language> language) {
		super();
		this.id = id;
		this.languageName = languageList;
		this.languages = language;
	}

	public LanguageList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguageList() {
		return languageName;
	}

	public void setLanguageList(String languageList) {
		this.languageName = languageList;
	}

	public List<Language> getLanguage() {
		return languages;
	}

	public void setLanguage(List<Language> language) {
		this.languages = language;
	}
}
