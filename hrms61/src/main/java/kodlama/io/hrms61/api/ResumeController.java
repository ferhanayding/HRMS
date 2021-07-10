package kodlama.io.hrms61.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import kodlama.io.hrms61.bussines.abstracts.ResumeService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.Resume;

@RestController
@RequestMapping("/resumeController/")
public class ResumeController {

	private ResumeService resumeService;

	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	@GetMapping("getall")
	public DataResult<List<Resume>> getAll(){
		
		return this.resumeService.getAll();
	}
	@PostMapping(value="add")
	public Result add(@RequestBody Resume resume) {
		
		return this.resumeService.add(resume);
	}
	 
}
