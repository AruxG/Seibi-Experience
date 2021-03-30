package es.codeurjc.SeibiExperiencieSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.SeibiExperiencieSpring.model.Orderz;
import es.codeurjc.SeibiExperiencieSpring.repository.OrderzRepository;

@RestController
public class PDFController {

	@Autowired
	private OrderzRepository orders;
	
	@GetMapping("/pdf/{id}")
	public Orderz generarPDF(@RequestParam Long id) {
		Orderz orderz = orders.findById(id).orElseThrow();
		return orderz;
	}
}
