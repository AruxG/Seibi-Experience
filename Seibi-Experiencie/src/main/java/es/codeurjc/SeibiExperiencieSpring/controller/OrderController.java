package es.codeurjc.SeibiExperiencieSpring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.SeibiExperiencieSpring.model.Order;
import es.codeurjc.SeibiExperiencieSpring.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderRepository orders;
	
	
	@GetMapping("/")
	public Collection<Order> getOrders(){
		return orders.findAll();
	}
}
