package es.codeurjc.SeibiExperiencieSpring.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.SeibiExperiencieSpring.model.Orderz;

@CacheConfig(cacheNames="seibi")
public interface OrderzRepository extends JpaRepository<Orderz,Long>{
	@Cacheable
	Orderz findById(long id);
	
	@CacheEvict(allEntries = true)
	@Override
	<S extends Orderz> S save(S s);
}
