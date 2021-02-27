package es.codeurjc.SeibiExperiencieSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.SeibiExperiencieSpring.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	User findByName(String user);
}
