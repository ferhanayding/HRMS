package kodlama.io.hrms61.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms61.entities.concretes.LanguageList;

public interface LanguageListDao extends JpaRepository<LanguageList,Integer> {

}
