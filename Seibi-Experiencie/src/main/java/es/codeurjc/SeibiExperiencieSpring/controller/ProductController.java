package es.codeurjc.SeibiExperiencieSpring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.SeibiExperiencieSpring.model.Product;
import es.codeurjc.SeibiExperiencieSpring.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository products;
	
	@GetMapping("/")
	public Collection<Product> getProducts(){
		return products.findAll();
	}
}