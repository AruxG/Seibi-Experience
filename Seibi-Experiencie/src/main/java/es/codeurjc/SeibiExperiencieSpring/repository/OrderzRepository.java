package es.codeurjc.SeibiExperiencieSpring.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.SeibiExperiencieSpring.model.Orderz;

@CacheConfig(cacheNames="Orderz")
public interface OrderzRepository extends JpaRepository<Orderz,Long>{
	
}
