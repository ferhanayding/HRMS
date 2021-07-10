package kodlama.io.hrms61.bussines.abstracts;

import java.util.List;

import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.Tech;

public interface TechService  {

	DataResult<List<Tech>> getAll();
	Result add(Tech tech);
	
	
}
