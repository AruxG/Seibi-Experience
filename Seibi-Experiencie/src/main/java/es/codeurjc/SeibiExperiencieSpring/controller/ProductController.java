package es.codeurjc.SeibiExperiencieSpring.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.SeibiExperiencieSpring.model.Product;
import es.codeurjc.SeibiExperiencieSpring.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository products;
	
	@PostConstruct
	public void init() {
		String activities = "Desayuno, Museo del prado, Aperitivo";
		products.save(new Product("MadridByMorning", activities,"Madrid","Mañana",null,"Ideal para conocer Madrid"));
		activities = "Almuerzo en terraza con vistas a la ciudad, Escape Room Lever, Merienda";
		products.save(new Product("MadridByEvening", activities,"Madrid","Tarde",null,"Vas a adorar Madrid"));
	}
	
	@GetMapping("/")
	public String showPosts(Model model, HttpSession session) {

		model.addAttribute("products", products.findAll());
		model.addAttribute("welcome", session.isNew());

		return "index";
	}
	
	@GetMapping("/product/{id}")
	public String showPost(Model model, @PathVariable long id) {

		Product product = products.findById(id).orElseThrow();

		model.addAttribute("product", product);

		return "show_product";
	}
}