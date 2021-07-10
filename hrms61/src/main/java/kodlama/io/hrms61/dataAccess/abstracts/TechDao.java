package kodlama.io.hrms61.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms61.entities.concretes.Tech;

public interface TechDao extends JpaRepository<Tech,Integer> {

}
