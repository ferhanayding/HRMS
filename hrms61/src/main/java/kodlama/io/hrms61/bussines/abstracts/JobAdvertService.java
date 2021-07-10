package kodlama.io.hrms61.bussines.abstracts;

import java.util.List;


import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.JobAdvert;
import kodlama.io.hrms61.entities.dtos.CompanyWithJobAdvertsDto;

public interface JobAdvertService {

	
	
	DataResult<List<JobAdvert>> getAll();
	
	Result add(JobAdvert jobAdvert);
	
	DataResult<List<JobAdvert>> getByActive();
	
	DataResult<List<JobAdvert>> getByIdAndEmployer_Id(int jobAdvertId, int employerId);
	
	DataResult<List<JobAdvert>> getAllSortedByMaxSalaryDesc();
	
	DataResult<List<JobAdvert>> getAllsortedByMaxSalaryAsc();
	
	DataResult<List<JobAdvert>> getAll(int pageNo,int pageSize);
	
	DataResult<List<JobAdvert>> getByCityName(String cityName);
	
	DataResult<List<JobAdvert>> getByEmployer_CompanyName(String companyName);

	DataResult<List<JobAdvert>> getByJobTitle_Title(String title);
	
	DataResult<List<CompanyWithJobAdvertsDto>> companyWithJobAdvertDetails();
	
	DataResult<List<JobAdvert>> getByCompanyNameAndJobAdvertId(String jobDescription,int employerId);
	
}
