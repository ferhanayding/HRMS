package kodlama.io.hrms61.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms61.bussines.abstracts.JobAdvertService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.JobAdvert;
import kodlama.io.hrms61.entities.dtos.CompanyWithJobAdvertsDto;

@RestController
@RequestMapping("api/jobadvert")
public class JobAdvertController {

	
	private JobAdvertService jobadvertService;
	@Autowired
	public JobAdvertController(JobAdvertService jobadvertService) {
		
		super();
	
		this.jobadvertService = jobadvertService;
	}

	@GetMapping("/getall")
	
	DataResult<List<JobAdvert>> getall(){
		
		return this.jobadvertService.getAll();
	
	}
		
	@PostMapping("/add")
	
	Result add(@RequestBody JobAdvert jobAdvert) {
		
		return this.jobadvertService.add(jobAdvert);
	
		}

	@GetMapping("/getbyactive")
    DataResult<List<JobAdvert>> getByActive(){
    	
		return this.jobadvertService.getByActive();
    
	}
	@GetMapping("/getByIdAndEmployer_Id")
	DataResult<List<JobAdvert>> getByIdAndEmployer_Id( @RequestParam int jobAdvertId,@RequestParam int employerId){
		
		return this.jobadvertService.getByIdAndEmployer_Id(jobAdvertId, employerId);
		
	}
	@GetMapping("getAllSortedByMaxSalaryDesc")
	DataResult<List<JobAdvert>> getAllSortedByMaxSalaryDesc(){
		
		return this.jobadvertService.getAllSortedByMaxSalaryDesc();
	
	}
	
	@GetMapping("getAllsortedByMaxSalaryAsc")
	DataResult<List<JobAdvert>> getAllsortedByMaxSalaryAsc(){
		
		return this.jobadvertService.getAllsortedByMaxSalaryAsc();
	
	}
	
	@GetMapping("getAllForSizeAndNo")
    DataResult<List<JobAdvert>> getAll(int pageNo,int pageSize){ 
		
		return this.jobadvertService.getAll(pageNo,pageSize);
	
	}
    @GetMapping("getByCity_CityName")
    DataResult<List<JobAdvert>> getByCity_CityName(@RequestParam String cityName){
    	
    	return this.jobadvertService.getByCityName(cityName);
    
    }
    
    @GetMapping("getByEmployer_CompanyName")
    DataResult<List<JobAdvert>> getByEmployer_CompanyName(@RequestParam String companyName){
    	
    	return this.jobadvertService.getByEmployer_CompanyName(companyName);
    	
    }
    
    @GetMapping("getByJobTitle_Title")
	DataResult<List<JobAdvert>> getByJobTitle_Title(@RequestParam String title){
    	
    	return this.jobadvertService.getByJobTitle_Title(title);
    	
    }
    @GetMapping("/companyWithJobAdvertDetails")
    DataResult<List<CompanyWithJobAdvertsDto>> companyWithJobAdvertDetails(){
    	
    	return this.jobadvertService.companyWithJobAdvertDetails();
    }
    @GetMapping("/getByCompanyNameAndJobAdvertId")
    DataResult<List<JobAdvert>> getByCompanyNameAndJobAdvertId(@RequestParam String jobDescription,@RequestParam int employerId	){
    	
    	return this.jobadvertService.getByCompanyNameAndJobAdvertId(jobDescription,employerId);
    
    }
    
}
