package kodlama.io.hrms61.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms61.bussines.abstracts.EducationService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.Education;

@RestController
@RequestMapping("/Educationcontroller/")
public class Educationcontroller {

	
	private EducationService educationService;
	
	
	@Autowired
	public Educationcontroller(EducationService educationService) {
		super();
		this.educationService=educationService;
	}
	@GetMapping("getall")
	public DataResult<List<Education>> getAll(){

		return this.educationService.getAll();
	
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Education education) {
		
		return this.educationService.add(education);
	
	}
}
