package kodlama.io.hrms61.entities.dtos;






public class CompanyWithJobAdvertsDto {

	private int id;
	private String companyName;
	private String title;
	private String jobDescription;
	private int minSalary;
	private int maxSalary; 
	private int OpenPosition;
	
	
	public CompanyWithJobAdvertsDto(int id,String companyName, String title, String jobDescription, int minSalary, int maxSalary,
			int openPosition) {
		super();
		this.id = id;
		this.companyName=companyName;
		this.title = title;
		this.jobDescription = jobDescription;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		OpenPosition = openPosition;
	
	}
	public CompanyWithJobAdvertsDto() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public int getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
	public int getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	public int getOpenPosition() {
		return OpenPosition;
	}
	public void setOpenPosition(int openPosition) {
		OpenPosition = openPosition;
	}


	
	
	
}
