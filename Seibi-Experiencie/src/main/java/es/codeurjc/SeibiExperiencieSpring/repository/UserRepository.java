package es.codeurjc.SeibiExperiencieSpring.repository;

import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import es.codeurjc.SeibiExperiencieSpring.model.Product;
import es.codeurjc.SeibiExperiencieSpring.model.User;


public interface UserRepository extends CrudRepository<User,Long>{

	Optional<User> findByName(String user);

	<S extends User> S save(S s);
}
