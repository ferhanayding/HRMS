package kodlama.io.hrms61.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms61.bussines.abstracts.ExperienceService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.Experience;

@RestController
@RequestMapping("/ExperienceController/")
public class ExperienceController {

	private ExperienceService experienceService;
	
	@Autowired
	public ExperienceController(ExperienceService experienceService) {
		super();
		this.experienceService=experienceService;
	}

	@GetMapping("getall")
	public DataResult<List<Experience>> getAll(){
		
		return this.experienceService.getAll();
		
	}

	@PostMapping("add")
	public Result add(@RequestBody Experience experience) {
		
		return this.experienceService.add(experience);
	
	}
	
}

