package kodlama.io.hrms61.core.adepters.concretes;

import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlama.io.hrms61.core.adepters.abstracts.VerificationCodeService;

@Service
public class VerificationCodeManager implements VerificationCodeService {
	
	
	@Override
	public boolean sendVerificationCode(String email) {
	   
		UUID uuid = UUID.randomUUID();
	    String code= uuid.toString().substring(0,5);
		
	    
		
		if(email.isEmpty()) {
			
		   return false;
		}
	
//		 System.out.println(email +"Verification code sent to address . Verification code:" + code );
		 
		    return true;	
	}
	
	

	
	
	
}
