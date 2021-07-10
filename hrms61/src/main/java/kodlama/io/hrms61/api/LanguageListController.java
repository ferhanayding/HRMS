package kodlama.io.hrms61.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms61.bussines.abstracts.LanguageListSerive;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.LanguageList;

@RestController
@RequestMapping("/LanguageListController/")
public class LanguageListController {

	private LanguageListSerive languageListSerive;

	@Autowired
	public LanguageListController(LanguageListSerive languageListSerive) {
		super();
		this.languageListSerive = languageListSerive;
	}
	@GetMapping("getall")
	public DataResult<List<LanguageList>> getAll(){
		return this.languageListSerive.getAll();
		}

	@PostMapping("add")
	public Result add(@RequestBody LanguageList languageList) {
		return this.languageListSerive.add(languageList);
		
		
		
	}

}

