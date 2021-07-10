package kodlama.io.hrms61.core.adepters.concretes;





import java.time.LocalDate;

import org.springframework.stereotype.Service;

import kodlama.io.hrms61.core.adepters.abstracts.FakeMernisService;
import kodlama.io.hrms61.services.fakeMernis.FakeMernis;



@Service
public  class MernisCheckAdapter implements FakeMernisService {

	private FakeMernis fakeMernis;
	
	
	
	public MernisCheckAdapter(FakeMernis fakeMernis) {
		super();
		this.fakeMernis = fakeMernis;
	}



	@Override
	public boolean isOkayMernis(String identityNumber, String firstName, String lastName,LocalDate birthDay) {
		
		return this.fakeMernis.isOkay(identityNumber, firstName, lastName, lastName);
	
	}

	
	
}
