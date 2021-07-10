package kodlama.io.hrms61.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms61.bussines.abstracts.EducationLevelService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.EducationLevel;

@RestController
@RequestMapping("/EducationLevelController/")
public class EducationLevelController {

	
	private EducationLevelService educationLevelService;
	@Autowired
	public EducationLevelController(EducationLevelService educationLevelService) {
		super();
		this.educationLevelService=educationLevelService;
	}

 
	@GetMapping("getall")
	public DataResult<List<EducationLevel>> getAll(){
		
		return this.educationLevelService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody EducationLevel educationLevel) {
		return this.educationLevelService.add(educationLevel);
	}
}

