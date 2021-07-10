package kodlama.io.hrms61.bussines.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms61.bussines.abstracts.ResumeService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.SuccessDataResult;
import kodlama.io.hrms61.core.utitiles.results.SuccessResult;
import kodlama.io.hrms61.dataAccess.abstracts.ResumeDao;
import kodlama.io.hrms61.entities.concretes.Resume;
import kodlama.io.hrms61.core.utitiles.results.Result;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	
	
	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),"listelendi...");
	}
// getalla gerek var mı bılmıyorum ama ekledım
	
	@Override
	public Result add(Resume resume) {
			
		 this.resumeDao.save(resume);
		 return new SuccessResult("cv niz kayıt olunmustur...");
		
	}

}
