package es.codeurjc.SeibiExperiencieSpring.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.SeibiExperiencieSpring.model.Comment;
import es.codeurjc.SeibiExperiencieSpring.model.Product;

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
	
	@Cacheable
	Product findById(long id);
	
	@CacheEvict(allEntries=true)
	Product save(Product product);
}
