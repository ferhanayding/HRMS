package kodlama.io.hrms61.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms61.entities.concretes.LanguageLevel;


public interface LanguageLevelDao extends JpaRepository<LanguageLevel,Integer> {

}
