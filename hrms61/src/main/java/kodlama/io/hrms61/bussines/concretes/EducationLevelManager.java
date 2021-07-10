package kodlama.io.hrms61.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms61.bussines.abstracts.EducationLevelService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.core.utitiles.results.SuccessDataResult;
import kodlama.io.hrms61.core.utitiles.results.SuccessResult;
import kodlama.io.hrms61.dataAccess.abstracts.EducationLevelDao;
import kodlama.io.hrms61.entities.concretes.EducationLevel;

@Service
public class EducationLevelManager implements EducationLevelService{

	private EducationLevelDao educationLevelDao;
	
	@Autowired
	public EducationLevelManager(EducationLevelDao educationLevelDao) {
		this.educationLevelDao=educationLevelDao;
	}

	@Override
	public DataResult<List<EducationLevel>> getAll() {
		return new SuccessDataResult<List<EducationLevel>>(this.educationLevelDao.findAll());
	}

	@Override
	public Result add(EducationLevel educationLevel) {
		this.educationLevelDao.save(educationLevel);
		return new SuccessResult("kayot edildi...");
	}
	
	
}
