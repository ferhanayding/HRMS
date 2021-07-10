package kodlama.io.hrms61.services.fakeMernis;




import org.springframework.stereotype.Component;

@Component
public class FakeMernis {
	
	public boolean isOkay(String tcNo, String firstName,String lastName,String password) {
		
		if(tcNo.length()<11 || firstName.isEmpty()  || lastName.isEmpty() || password.equals(tcNo) ) {
			
			return false;
			
		}
		return true;
	}
}
