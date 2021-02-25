package es.codeurjc.SeibiExperiencieSpring.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.SeibiExperiencieSpring.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Page<Product> findByCity(String city, Pageable page);
	Page<Product> findByTime(String time, Pageable page);
	Page<Product> findByCityAndTime(String city, String time, Pageable page);
}
