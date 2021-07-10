package kodlama.io.hrms61.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms61.bussines.abstracts.TechService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.core.utitiles.results.SuccessDataResult;
import kodlama.io.hrms61.core.utitiles.results.SuccessResult;
import kodlama.io.hrms61.dataAccess.abstracts.TechDao;
import kodlama.io.hrms61.entities.concretes.Tech;

@Service
public class TechManager implements TechService{

	private TechDao techDao;

	@Autowired
	public TechManager(TechDao techDao) {
		super();
		this.techDao = techDao;
	}

	@Override
	public DataResult<List<Tech>> getAll() {

		return new SuccessDataResult<List<Tech>>(this.techDao.findAll(),"listelendi...");
		
	}

	@Override
	public Result add(Tech tech) {
		this.techDao.save(tech);
		return new SuccessResult("eklendi...");
	}
	
	
	
}
