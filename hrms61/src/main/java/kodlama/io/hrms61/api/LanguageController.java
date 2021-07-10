package kodlama.io.hrms61.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms61.bussines.abstracts.LanguageService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.Language;

@RestController
@RequestMapping("/LanguageController/")
public class LanguageController {

	
	private LanguageService languageService;
	@Autowired
	LanguageController(LanguageService languageService){
		super();
		this.languageService=languageService;
	}
	@GetMapping("getall")
	public DataResult<List<Language>> getAll(){
		
		return this.languageService.getAll();
	
	}
	@PostMapping("add")
	public Result add(@RequestBody Language language) {
		return this.languageService.add(language);
	}
}
