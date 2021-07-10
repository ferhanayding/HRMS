package kodlama.io.hrms61.entities.concretes;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="verification_codes")
public class VerificationCode {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	
	@Column(name="is_verified",columnDefinition="boolean default false")
	private boolean isVerified;
	
	@Column(name="verified_date")
	private LocalDateTime verificationDate = LocalDateTime.now();

	public VerificationCode(int id, String code, boolean isVerified, LocalDateTime verificationDate) {
		super();
		this.id = id;
		this.code = code;
		this.isVerified = isVerified;
		this.verificationDate = verificationDate;
	}
	public VerificationCode() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public LocalDateTime getVerificationDate() {
		return verificationDate;
	}
	public void setVerificationDate(LocalDateTime verificationDate) {
		this.verificationDate = verificationDate;
	}


	
	
}
