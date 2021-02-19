package es.codeurjc.SeibiExperiencieSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.SeibiExperiencieSpring.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
