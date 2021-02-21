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

import es.codeurjc.SeibiExperiencieSpring.model.Comment;
import es.codeurjc.SeibiExperiencieSpring.model.Product;
import es.codeurjc.SeibiExperiencieSpring.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository products;
	
	@PostConstruct
	public void init() {
		//Madrid experiences
		String activities = "Desayuno, Museo del prado, Aperitivo";
		products.save(new Product("MadridByMorning", activities,"Madrid","Mañana",null,"Ideal para conocer Madrid"));
		activities = "Almuerzo en terraza con vistas a la ciudad, Escape Room Lever, Merienda";
		products.save(new Product("MadridByEvening", activities,"Madrid","Tarde",null,"Vas a adorar Madrid"));
		activities = "Rocódromo, Cena, ver El rey León";
		products.save(new Product("MadridByNight", activities,"Madrid","Noche",null,"Una noche de fantasía en Madrid"));
		
		//Barcelona experiences
		activities = "Desayuno, visitar Sagrada Familia";
		products.save(new Product("BarcelonaByMorning", activities,"Barcelona","Mañana",null,"Ideal para conocer Barcelona"));
		activities = "Almuerzo en una terraza con vistas a la ciudad, visitar Parque Güell, merienda";
		products.save(new Product("BarcelonaByEvening", activities,"Barcelona","Tarde",null,"Vas a adorar Barcelona"));
		activities = "Cena en un yate con vistas al mar y música en directo de la mano de Sailing Experience";
		products.save(new Product("BarcelonaByNight", activities,"Barcelona","Noche",null,"Una noche de fantasía en Barcelona"));
		
		//Toledo experiences
		activities = "Desayuno, Visita guiada por los monumentos más importantes de Toledo";
		products.save(new Product("ToledoByMorning", activities,"Toledo","Mañana",null,"Ideal para conocer Toledo"));
		activities = "Almuerzo, circuito de spa con masaje incluido y merienda temática";
		products.save(new Product("ToledoByEvening", activities,"Toledo","Tarde",null,"Vas a adorar Toledo"));
		activities = "Cena en hotel burbuja contemplando las estrellas";
		products.save(new Product("ToledoByNight", activities,"Toledo","Noche",null,"Una noche de fantasía en Toledo"));
		
		//Sevilla experiences
		activities = "Desayuno, visita guiada por el casco antiguo de Sevilla";
		products.save(new Product("SevillaByMorning", activities,"Sevilla","Mañana",null,"Ideal para conocer Sevilla"));
		activities = "Almuerzo con vistas al río Guadalquivir, kayak por el río";
		products.save(new Product("SevillaByEvening", activities,"Sevilla","Tarde",null,"Vas a adorar Sevilla"));
		activities = "Cena en Tablao Flamenco con espectáculo";
		products.save(new Product("SevillaByNight", activities,"Sevilla","Noche",null,"Una noche de fantasía en Sevilla"));
		
		//Pontevedra experiences
		activities = "Desayuno, visita a enoteca con cata";
		products.save(new Product("SevillaByMorning", activities,"Pontevedra","Mañana",null,"Ideal para conocer Pontevedra"));
		activities = "Almuerzo con mariscada, clase de surf";
		products.save(new Product("SevillaByEvening", activities,"Pontevedra","Tarde",null,"Vas a adorar Pontevedra"));
		activities = "Noche en hórreos con cena incluida";
		products.save(new Product("SevillaByNight", activities,"Pontevedra","Noche",null,"Una noche de fantasía en Pontevedra"));
		
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