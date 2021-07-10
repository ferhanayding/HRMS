package kodlama.io.hrms61.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms61.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	Candidate findByEmail(String email);
	Candidate findByİdentityNumber(String identityNumber);
	

}
