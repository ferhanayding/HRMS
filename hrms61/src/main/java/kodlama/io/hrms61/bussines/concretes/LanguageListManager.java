package kodlama.io.hrms61.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms61.bussines.abstracts.LanguageListSerive;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.core.utitiles.results.SuccessDataResult;
import kodlama.io.hrms61.core.utitiles.results.SuccessResult;
import kodlama.io.hrms61.dataAccess.abstracts.LanguageListDao;
import kodlama.io.hrms61.entities.concretes.LanguageList;

@Service
public class LanguageListManager  implements LanguageListSerive{

	private LanguageListDao languageListDao;

	@Autowired
	public LanguageListManager(LanguageListDao languageListDao) {
		super();
		this.languageListDao = languageListDao;
	}

	@Override
	public DataResult<List<LanguageList>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<LanguageList>>(this.languageListDao.findAll(),"listendi...");
	}

	@Override
	public Result add(LanguageList languageList) {

		this.languageListDao.save(languageList);
		return new SuccessResult("kayot oldu...");
	}
	
	
}
