package es.codeurjc.SeibiExperiencieSpring.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.codeurjc.SeibiExperiencieSpring.model.Product;

@Repository
@CacheConfig(cacheNames="products")
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Cacheable
	Page<Product> findByCity(String city, Pageable page);
	@Cacheable
	Page<Product> findByTime(String time, Pageable page);
	@Cacheable
	Page<Product> findByCityAndTime(String city, String time, Pageable page);

	@Cacheable
	Page<Product> findAll(Pageable page);
	
	Product findById(long id);
	
	@CacheEvict(allEntries = true)
	@Override
	<S extends Product> S save(S s);

}
