package kodlama.io.hrms61.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms61.bussines.abstracts.LanguageService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.core.utitiles.results.SuccessDataResult;
import kodlama.io.hrms61.core.utitiles.results.SuccessResult;
import kodlama.io.hrms61.dataAccess.abstracts.LanguageDao;
import kodlama.io.hrms61.entities.concretes.Language;
@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao=languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
		
	}

	@Override
	public Result add(Language language) {
		
		this.languageDao.save(language);
		return new SuccessResult("listelendi...");
	}

}
