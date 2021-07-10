package kodlama.io.hrms61.dataAccess.abstracts;


import java.util.List;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms61.entities.concretes.JobAdvert;
import kodlama.io.hrms61.entities.dtos.CompanyWithJobAdvertsDto;


public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer> {

	 List<JobAdvert> getByActive(boolean active);

	 //	 actıve mı ye gore 
	 
	 List<JobAdvert> getByIdAndEmployer_Id(int jobAdvertId, int employerId);

	 //	eployer id ye gore arama ki bence cok sacma sadce hoca yaptı dıye yaptım 
	 
	 List<JobAdvert> getByCity_CityName(String cityName);

	 //	 citye gore arama

	 List<JobAdvert> getByEmployer_CompanyName(String companyName);

	 //	 employera gore

	 List<JobAdvert> getByJobTitle_Title(String title);

    //	 job title ye gore 
	 
	 @Query("Select new kodlama.io.hrms61.entities.dtos.CompanyWithJobAdvertsDto"
	 		+ "(j.id,e.companyName,j.jobTitle.title,j.jobDescription,j.minSalary,j.maxSalary,j.OpenPosition)"
	 		+ "From Employer e Inner Join e.jobAdverts j")	 
	 List<CompanyWithJobAdvertsDto> employerWithJobAdvertDetails();
	 
	 
	 @Query("From JobAdvert where jobDescription=:jobDescription and employer.id=:employerId")
		List<JobAdvert> getByNameAndId(String jobDescription,int employerId);
//	 employerın id jobadvertın acıklamasını
	
}
