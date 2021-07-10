package kodlama.io.hrms61.core.adepters.abstracts;

import java.time.LocalDate;

public interface FakeMernisService {

	boolean isOkayMernis(String identityNumber, String firstName,String lastName,LocalDate birthDay);
	
	
}
