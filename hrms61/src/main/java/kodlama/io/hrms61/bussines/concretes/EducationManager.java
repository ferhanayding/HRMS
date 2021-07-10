package kodlama.io.hrms61.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms61.bussines.abstracts.EducationService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.core.utitiles.results.SuccessDataResult;
import kodlama.io.hrms61.core.utitiles.results.SuccessResult;
import kodlama.io.hrms61.dataAccess.abstracts.EducationDao;
import kodlama.io.hrms61.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {


	private EducationDao educationDao;
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao=educationDao;
	}

	@Override
	public DataResult<List<Education>> getAll() {
		
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"egitimler listelendi...");
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("eklendi");
	}
	
}
