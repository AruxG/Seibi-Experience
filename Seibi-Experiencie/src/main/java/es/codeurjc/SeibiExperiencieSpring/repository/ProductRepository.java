package es.codeurjc.SeibiExperiencieSpring.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.SeibiExperiencieSpring.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
