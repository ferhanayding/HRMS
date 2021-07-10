package kodlama.io.hrms61.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms61.bussines.abstracts.JobTitleService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitleControllers {

		JobTitleService jobTitleService;

		@Autowired
		public JobTitleControllers(JobTitleService jobTitleService) {
			super();
			this.jobTitleService = jobTitleService;
		}
		
		@GetMapping("/getall")
		public DataResult<List<JobTitle>> getAlll(){
			
			return this.jobTitleService.getAll();
			
		}
		@PostMapping("/add")
		public Result add(@RequestBody JobTitle jobTitle){
			return this.jobTitleService.add(jobTitle);
		}
		
		
}
