package kodlama.io.hrms61.bussines.concretes;

import java.util.List;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.hrms61.bussines.abstracts.JobAdvertService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.ErrorDataResult;
import kodlama.io.hrms61.core.utitiles.results.ErrorResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.core.utitiles.results.SuccessDataResult;
import kodlama.io.hrms61.core.utitiles.results.SuccessResult;
import kodlama.io.hrms61.dataAccess.abstracts.JobAdvertDao;
import kodlama.io.hrms61.entities.concretes.JobAdvert;
import kodlama.io.hrms61.entities.dtos.CompanyWithJobAdvertsDto;
@Service
public class JobAdvertManager implements JobAdvertService {

	
	private JobAdvertDao jobAdvertDao;

	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		
	 return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(),"iş ilanları başarıyla listelendi..."		);
		
	}
	
	@Override
	public Result add(JobAdvert jobAdvert) {
		
		if(jobAdvert.getJobDescription().isEmpty() || jobAdvert.getCity().toString().isEmpty() || jobAdvert.getEmployer().toString().isEmpty() 
				)
				 {
		return new ErrorResult("bos alan  bırakamazsınız!!!");
//		}else if(jobAdvert.getApplicationDeadline().equals(jobAdvert.getCreatedAt())) {
//			
//			return new ErrorResult("ilanın bitiş tarihi ile acılıs tarıhı aynı olamaz!!!");
//		
		}
		
		this.jobAdvertDao.save(jobAdvert);
		
		return new SuccessResult("basarıyla eklendi: ");
	}
	
	
	
	
	@Override
	public DataResult<List<JobAdvert>> getByActive() {

		return  new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByActive(true),"aktif olanlar listelendi");
	
	}
	@Override
	public DataResult<List<JobAdvert>> getByIdAndEmployer_Id(int jobAdvertId, int employerId) {


		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIdAndEmployer_Id(jobAdvertId, employerId),"listelendi getByIdAndEmployer_Id ");
		
		
	
	}
	@Override
	public DataResult<List<JobAdvert>> getAllSortedByMaxSalaryDesc() {
		
		Sort sort = Sort.by(Sort.Direction.DESC,"maxSalary");   
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort),"maaşlar coktan aza dogru sıralandı...");
		   	
	}
	@Override
	public DataResult<List<JobAdvert>> getAllsortedByMaxSalaryAsc() {
		
		Sort sort=Sort.by(Sort.Direction.ASC,"maxSalary");
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort),"maaşlar azdan coga dogru sıralandı...");
	
	}
	@Override
	public DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable=PageRequest.of(pageNo-1,pageSize);
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(pageable).getContent(),"girdiginiz sizeda listelendi...");
		
	}
	@Override
	public DataResult<List<JobAdvert>> getByCityName(String cityName) {
//		istedigi sehir olmayınca findall dan null sa dicem
		if(this.jobAdvertDao.getByCity_CityName(cityName).isEmpty()) {
		
			return new ErrorDataResult<List<JobAdvert>>("giridginiz sehire ait iş ilanı bulunmamaktadır!!!");
	
		}
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByCity_CityName(cityName),"giridiginiz sehire ait iş ilanları getırılmıstır");
		
	}	
	@Override
	public DataResult<List<JobAdvert>> getByEmployer_CompanyName(String companyName) {
		if(this.jobAdvertDao.getByEmployer_CompanyName(companyName).isEmpty()) {
			
			return new ErrorDataResult<List<JobAdvert>>("giridginiz sirkete ait iş ilanı bulunmamaktadır!!!");
		}
	   return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployer_CompanyName(companyName),"girdiginiz sırket adına ait ilanlar listelendi...");	
	
	}
	@Override
	public DataResult<List<JobAdvert>> getByJobTitle_Title(String title) {
if(this.jobAdvertDao.getByJobTitle_Title(title).isEmpty()) {
			
			return new ErrorDataResult<List<JobAdvert>>("giridginiz başlığa ait iş ilanı bulunmamaktadır!!!");
		}
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByJobTitle_Title(title),"girdigniz baslıga gore ilanlar listelendi...");
	
	}
	@Override
	public DataResult<List<CompanyWithJobAdvertsDto>> companyWithJobAdvertDetails() {
		
		return new SuccessDataResult<List<CompanyWithJobAdvertsDto>>(this.jobAdvertDao.employerWithJobAdvertDetails(),
				"şirketler ve onlara ait ilanlar listelenmiştir efenim");
	}
	@Override
	public DataResult<List<JobAdvert>> getByCompanyNameAndJobAdvertId(String jobDescription,int employerId) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByNameAndId(jobDescription,employerId),"data listelnedi...");
	}
	

	
	
	
	
}
