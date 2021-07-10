package kodlama.io.hrms61.bussines.concretes;

import java.util.List;



import org.springframework.stereotype.Service;

import kodlama.io.hrms61.bussines.abstracts.EmployerService;
import kodlama.io.hrms61.core.adepters.abstracts.HrmsCheckService;
import kodlama.io.hrms61.core.adepters.abstracts.VerificationCodeService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.ErrorResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.core.utitiles.results.SuccessDataResult;
import kodlama.io.hrms61.core.utitiles.results.SuccessResult;
import kodlama.io.hrms61.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms61.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private HrmsCheckService hrmsCheckService;
	private VerificationCodeService codeService;
	
	
	
	public EmployerManager(EmployerDao employerDao,HrmsCheckService hrmsCheckService,VerificationCodeService codeService) {
		super();
		this.employerDao = employerDao;
		this.hrmsCheckService=hrmsCheckService;
		this.codeService=codeService;
			}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"data listelendi...");
		
	}

	@Override
	public Result add(Employer employer) {
		if((this.employerDao.findByPhoneNumber(employer.getPhoneNumber())!=null ||
				(this.employerDao.findByCompanyName(employer.getCompanyName())!=null ||
				this.employerDao.findByWebAdress(employer.getWebAdress())!=null))){
		
			return new ErrorResult("sistemde kayıtlı numara,web adress veya şirket ismi girdiniz!!! ");
		
		}else if(this.hrmsCheckService.isOkayPassword(employer.getPassword(),employer.getEmail())==false) {
			
			return new ErrorResult("şifre hatalı veya "+employer.getEmail()+" ile aynı!!!");
			
		}else if(this.hrmsCheckService.isOkeyPhoneNumber(employer.getPhoneNumber())==false) {
		
			return new ErrorResult("girdiginiz telefon numarası geçerli degil!!!");
		
		}else if(this.hrmsCheckService.isOkayEmail(employer.getEmail())==false) {
		
			return new ErrorResult("mailinizi hatalı girdiniz!!!");
		
		}else if(this.hrmsCheckService.isOkayDomain(employer.getWebAdress(), employer.getEmail())==false) {
			
			return new ErrorResult("web adresi ile email ile eşleşmedi!!!");
			
		}
		else {
			
			this.employerDao.save(employer);
			this.codeService.sendVerificationCode(employer.getEmail());
			return new SuccessResult("kayıt oldun, dogrulama kodu maile gonderildi");
		
		}
		
	}

//	@Override
//	public DataResult<List<Employer>> getByNameAndJobAdvert(String companyName,int jobAdvertId) {
//		
//		return new SuccessDataResult<List<Employer>>(this.employerDao.getByNameAndJobAdvert(companyName,jobAdvertId),"data listlendi... ");
//	
//	}

		
		
	}


