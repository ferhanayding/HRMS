package kodlama.io.hrms61.bussines.abstracts;

import java.util.List;


import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	
	Result add(Employer employer);
	
//	DataResult<List<Employer>> getByNameAndJobAdvert(String companyName,int jobAdvertId);
}
