package kodlama.io.hrms61.bussines.concretes;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms61.bussines.abstracts.CandidateService;
import kodlama.io.hrms61.core.adepters.abstracts.FakeMernisService;
import kodlama.io.hrms61.core.adepters.abstracts.HrmsCheckService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.ErrorResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.core.utitiles.results.SuccessDataResult;
import kodlama.io.hrms61.core.utitiles.results.SuccessResult;
import kodlama.io.hrms61.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms61.entities.concretes.Candidate;
@Service
public class CandidateManager implements CandidateService {

	
	private CandidateDao candidateDao;
	private HrmsCheckService hrmsCheckService;
	private FakeMernisService fakeMernisService;
	
    
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,HrmsCheckService hrmsCheckService,FakeMernisService fakeMernisService
			) {
		super();
		this.candidateDao = candidateDao;
		
		this.hrmsCheckService=hrmsCheckService;
		this.fakeMernisService=fakeMernisService;
		
		
	
	}




	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"data listelendi");
	
	}
	@Override
	public Result add(Candidate candidate) {
		
		if(!this.hrmsCheckService.isOkayEmail(candidate.getEmail())){ 
			
			return  new ErrorResult("email dogrulanmadı...");
		
		}else if(this.fakeMernisService.isOkayMernis(candidate.getIdentityNumber(),candidate.getFirstName()
				,candidate.getLastName(),candidate.getBirthDay())==false) {
			
			return new ErrorResult("tc yanlış:kullanıcı dogrulanamadı veya tc niz şifrenizle aynı olamaz ...");
			
		}else if(this.candidateDao.findByİdentityNumber(candidate.getIdentityNumber())!=null  || 
				this.candidateDao.findByEmail(candidate.getEmail())!=null)
		{
			return new ErrorResult("bu mail veya tc no zaten mevcut...");
			
		}else if(candidate.getLastName().isEmpty() || candidate.getFirstName().isEmpty() || candidate.getIdentityNumber().isEmpty() || 
				candidate.getEmail().isEmpty()) {
			
			return new ErrorResult("boş alan bıraktınız veya hatalı giriş yaptınız!");
		
		}else if(this.hrmsCheckService.isOkayPassword(candidate.getPassword(),candidate.getEmail())==false) {
			return new ErrorResult("şifreniz kriterlere uygun değil veya "+candidate.getEmail()+" ile aynı");
		}
		
		
		else {
		
		
		this.candidateDao.save(candidate);	
		return new SuccessResult("eklendi...");
		
		
	}
	}

	
	
	
}
