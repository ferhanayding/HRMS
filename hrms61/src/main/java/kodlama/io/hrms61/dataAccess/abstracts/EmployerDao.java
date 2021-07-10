package kodlama.io.hrms61.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms61.entities.concretes.Employer;


public interface EmployerDao extends JpaRepository<Employer,Integer> {

	Employer findByPhoneNumber(String phoneNumber);
	Employer findByCompanyName(String companyName);
	Employer findByWebAdress(String webAdress);
	
	
//	@Query("from Employer where companyName=:companyName and id=:jobAdvertId")
//	List<Employer> getByNameAndJobAdvert(String companyName,int jobAdvertId);
}

//@Query("Select from Product where productName=:productName and category.categoryId=:categoryId")
//List<Product> getByNameAndCategory(String productName,int categoryId);
