package es.codeurjc.SeibiExperiencieSpring.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.codeurjc.SeibiExperiencieSpring.model.Orderz;

@Repository
@CacheConfig(cacheNames="orderzs")
public interface OrderzRepository extends JpaRepository<Orderz,Long>{
	@Cacheable
	List<Orderz> findAll();
	
	@Cacheable
	Orderz findById(long id);
	
	@CacheEvict(allEntries = true)
	@Override
	<S extends Orderz> S save(S s);
}
