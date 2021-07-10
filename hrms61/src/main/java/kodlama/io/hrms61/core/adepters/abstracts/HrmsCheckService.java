package kodlama.io.hrms61.core.adepters.abstracts;




public interface HrmsCheckService {

	
	
	boolean isOkayPassword(String password,String email);
	
	boolean isOkayEmail(String email);
	
	boolean isOkeyPhoneNumber(String phoneNumber);
	
	boolean isOkayDomain(String webAdress, String email);
	
	
	
	
	
	
	
	
	
	
	
	
	
}
