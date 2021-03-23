package es.codeurjc.SeibiExperiencieSpring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import es.codeurjc.SeibiExperiencieSpring.model.User;

public interface UserRepository extends CrudRepository<User,Long>{
	
	User findByName(String user);
}
