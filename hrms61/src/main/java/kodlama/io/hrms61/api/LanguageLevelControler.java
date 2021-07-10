package kodlama.io.hrms61.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms61.bussines.abstracts.LanguageLevelService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.LanguageLevel;

@RestController
@RequestMapping("LanguageLevelControler")
public class LanguageLevelControler {

	private LanguageLevelService languageLevelService;

	@Autowired
	public LanguageLevelControler(LanguageLevelService languageLevelService) {
		super();
		this.languageLevelService = languageLevelService;
	}
	
	@GetMapping("getall")
	public DataResult<List<LanguageLevel>> getAll(){
		
		return this.languageLevelService.getAll();
		
	}
	@PostMapping("add")
	public Result add(@RequestBody LanguageLevel languageLevel) {
		
		return this.languageLevelService.add(languageLevel);
		
	}
}
