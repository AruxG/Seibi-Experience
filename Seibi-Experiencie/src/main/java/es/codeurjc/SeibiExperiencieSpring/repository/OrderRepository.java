package es.codeurjc.SeibiExperiencieSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.SeibiExperiencieSpring.model.Order;
import es.codeurjc.SeibiExperiencieSpring.model.User;

public interface OrderRepository extends JpaRepository<Order,Long>{
	Order findByCompleteAndUser(boolean completado,User user);
}
