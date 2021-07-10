package kodlama.io.hrms61.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms61.bussines.abstracts.EmployerService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.Employer;

@RestController
@RequestMapping("api/employer")
public class EmployerController {
	
	private EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		
		return this.employerService.getAll();
		
	}
	@PostMapping
	public Result add(@RequestBody Employer employer) {
		
		return this.employerService.add(employer);
		
	}
//	@GetMapping("/getByNameAndJobAdvert")
//	public DataResult<List<Employer>> getByNameAndJobAdvert(@RequestParam String companyName,@RequestParam int jobAdvertId){
//		
//		return this.employerService.getByNameAndJobAdvert(companyName, jobAdvertId);
//	}
//	

}
