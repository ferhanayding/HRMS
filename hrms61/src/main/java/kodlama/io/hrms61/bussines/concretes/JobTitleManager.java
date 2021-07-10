package kodlama.io.hrms61.bussines.concretes;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms61.bussines.abstracts.JobTitleService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.ErrorResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.core.utitiles.results.SuccessDataResult;
import kodlama.io.hrms61.core.utitiles.results.SuccessResult;
import kodlama.io.hrms61.dataAccess.abstracts.JobTitleDao;
import kodlama.io.hrms61.entities.concretes.JobTitle;
@Service
public class JobTitleManager implements JobTitleService {

	JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		
		super();
		
		this.jobTitleDao = jobTitleDao;
	}






	@Override
	public DataResult<List<JobTitle>> getAll() {
		
		
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"data listelendi");

	
}






	@Override
	public Result add(JobTitle jobTitle) {
        if(this.jobTitleDao.findByTitle(jobTitle.getTitle())!=null) {
        	
        	return new ErrorResult("girdiginiz baslık zaten var!!!");
        
        }
        
        else {
        	this.jobTitleDao.save(jobTitle);
        	
    		return new SuccessResult("başlık eklendi...");
        }
		
		
	}






	





	
}
