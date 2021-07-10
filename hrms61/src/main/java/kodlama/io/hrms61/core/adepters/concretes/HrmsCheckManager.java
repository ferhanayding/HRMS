package kodlama.io.hrms61.core.adepters.concretes;

import org.springframework.stereotype.Service;


import kodlama.io.hrms61.core.adepters.abstracts.HrmsCheckService;

@Service
public class HrmsCheckManager implements HrmsCheckService {

	
	
	
	


//	@Override
//	public boolean checkIfRealPerson(Candidate candidate) {
//		
//	/*	if(this.fakeMernis.isOkay(candidate.getIdentityNumber(),candidate.getFirstName(), candidate.getLastName())) {
//			return true;
//		}
//		
//		return false;
//	}
//	*/
//	return	this.fakeMernis.isOkay(candidate.getIdentityNumber(),candidate.getFirstName(), candidate.getLastName(),candidate.getIdentityNumber());
//	}

	
	

	@Override
	public boolean isOkayPassword(String password,String email) {
		if(password.length()<6 || password.isEmpty()) {
			return false;
		}
		return true;
	
	
	}

	@Override
	public boolean isOkayEmail(String email) {
    
		 if(email.equals("HRMS@gmail.com") || email.length()<8 || email.length()>50) {
        	 return false;
         }
				return true;
	
	}

	@Override
	public boolean isOkeyPhoneNumber(String phoneNumber) {
    
	if(phoneNumber.length()==11 || phoneNumber.equals("55555555555")) {
			
			return true;
			
		}
		
		return false;
	
	}

	@Override
	public boolean isOkayDomain(String webAdress, String email) {
		String eMail= email.split("@")[1];
		if(webAdress.equals(eMail))
		return true;
			
		else
		return false;
	
	}
}
