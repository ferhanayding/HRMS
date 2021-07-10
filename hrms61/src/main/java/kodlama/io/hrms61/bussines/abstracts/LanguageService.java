package kodlama.io.hrms61.bussines.abstracts;

import java.util.List;

import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.Language;

public interface LanguageService {

	DataResult<List<Language>> getAll();
	
	Result add(Language language);
}
