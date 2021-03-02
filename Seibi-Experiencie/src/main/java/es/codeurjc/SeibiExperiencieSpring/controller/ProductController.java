package es.codeurjc.SeibiExperiencieSpring.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.SeibiExperiencieSpring.model.Orderz;
import es.codeurjc.SeibiExperiencieSpring.model.Product;
import es.codeurjc.SeibiExperiencieSpring.model.User;
import es.codeurjc.SeibiExperiencieSpring.repository.OrderzRepository;
import es.codeurjc.SeibiExperiencieSpring.repository.ProductRepository;
import es.codeurjc.SeibiExperiencieSpring.repository.UserRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository products;
	
	@Autowired
	private OrderzRepository orders;
	
	@Autowired
	private UserRepository users;
	
	@PostConstruct
	public void init() {
		//Madrid experiences
		String activities = "Desayuno, Museo del prado, Aperitivo";
		products.save(new Product("MadridByMorning", activities,"Madrid","Mañana",null,"Ideal para conocer Madrid",50));
		activities = "Almuerzo en terraza con vistas a la ciudad, Escape Room Lever, Merienda";
		products.save(new Product("MadridByEvening", activities,"Madrid","Tarde",null,"Vas a adorar Madrid",70));
		activities = "Rocódromo, Cena, ver El rey León";
		products.save(new Product("MadridByNight", activities,"Madrid","Noche",null,"Una noche de fantasía en Madrid",50));
		
		//Barcelona experiences
		activities = "Desayuno, visitar Sagrada Familia";
		products.save(new Product("BarcelonaByMorning", activities,"Barcelona","Mañana",null,"Ideal para conocer Barcelona",40));
		activities = "Almuerzo en una terraza con vistas a la ciudad, visitar Parque Güell, merienda";
		products.save(new Product("BarcelonaByEvening", activities,"Barcelona","Tarde",null,"Vas a adorar Barcelona",30));
		activities = "Cena en un yate con vistas al mar y música en directo de la mano de Sailing Experience";
		products.save(new Product("BarcelonaByNight", activities,"Barcelona","Noche",null,"Una noche de fantasía en Barcelona",60));
		
		//Toledo experiences
		activities = "Desayuno, Visita guiada por los monumentos más importantes de Toledo";
		products.save(new Product("ToledoByMorning", activities,"Toledo","Mañana",null,"Ideal para conocer Toledo",30));
		activities = "Almuerzo, circuito de spa con masaje incluido y merienda temática";
		products.save(new Product("ToledoByEvening", activities,"Toledo","Tarde",null,"Vas a adorar Toledo",45));
		activities = "Cena en hotel burbuja contemplando las estrellas";
		products.save(new Product("ToledoByNight", activities,"Toledo","Noche",null,"Una noche de fantasía en Toledo",50));
		
		//Sevilla experiences
		activities = "Desayuno, visita guiada por el casco antiguo de Sevilla";
		products.save(new Product("SevillaByMorning", activities,"Sevilla","Mañana",null,"Ideal para conocer Sevilla",60));
		activities = "Almuerzo con vistas al río Guadalquivir, kayak por el río";
		products.save(new Product("SevillaByEvening", activities,"Sevilla","Tarde",null,"Vas a adorar Sevilla",80));
		activities = "Cena en Tablao Flamenco con espectáculo";
		products.save(new Product("SevillaByNight", activities,"Sevilla","Noche",null,"Una noche de fantasía en Sevilla",30));
		
		//Pontevedra experiences
		activities = "Desayuno, visita a enoteca con cata";
		products.save(new Product("PontevedraByMorning", activities,"Pontevedra","Mañana",null,"Ideal para conocer Pontevedra",40));
		activities = "Almuerzo con mariscada, clase de surf";
		products.save(new Product("PontevedraByEvening", activities,"Pontevedra","Tarde",null,"Vas a adorar Pontevedra",50));
		activities = "Noche en hórreos con cena incluida";
		products.save(new Product("PontevedraByNight", activities,"Pontevedra","Noche",null,"Una noche de fantasía en Pontevedra",60));
		
		
	}
	
	@GetMapping("/")
	public String showPosts(Model model, HttpSession session,@PageableDefault(size = 5) Pageable page) {
		Page<Product> prod = products.findAll(page);
		
		model.addAttribute("products", prod);
		model.addAttribute("hasPrev", prod.hasPrevious());
		model.addAttribute("hasNext", prod.hasNext());
		model.addAttribute("nextPage", prod.getNumber()+1);
		model.addAttribute("prevPage", prod.getNumber()-1);		
		
		model.addAttribute("welcome", session.isNew());
		model.addAttribute("user",session.getValue("user"));
		model.addAttribute("ciudad", "Any");
		model.addAttribute("hora", "Any");
		return "index";
	}
	@PostMapping("/")
	public String showPostsFiltered(
			Model model, 
			HttpSession session, 
			@PageableDefault(size = 5) Pageable page, 
			@RequestParam String city, 
			@RequestParam String time) 
	{
		Page<Product> productsFiltered;
		if(!city.equals("Any") && !time.equals("Any")) {
			productsFiltered= products.findByCityAndTime(city, time, page);
		}else if(!city.equals("Any")) {
			productsFiltered= products.findByCity(city, page);
		}else if(!time.equals("Any")){
			productsFiltered= products.findByTime(time, page);
		}else {
			productsFiltered= products.findAll(page);
		}
		
		model.addAttribute("products", productsFiltered);
		model.addAttribute("hasPrev", productsFiltered.hasPrevious());
		model.addAttribute("hasNext", productsFiltered.hasNext());
		model.addAttribute("nextPage", productsFiltered.getNumber()+1);
		model.addAttribute("prevPage", productsFiltered.getNumber()-1);	
		model.addAttribute("user",session.getValue("user"));
		model.addAttribute("ciudad", city);
		model.addAttribute("hora", time);
		return "index";
	}
	@GetMapping("/products/{id}")
	public String showPost(Model model,HttpSession httpSession, @PathVariable long id) {
		User user=null;
		if (httpSession.getAttribute("user")!=null){
			user = users.findByName((httpSession.getAttribute("user")).toString());
		}
		Product product = products.findById(id).orElseThrow();
		if(user!=null) {
			if(user.containsProduct(product)) {
				model.addAttribute("Carrito", true);
			}
		}
		model.addAttribute("product", product);
		model.addAttribute("user", httpSession.getValue("user"));
		return "show_product";
	}
	@PostMapping("/products/{id}")
	public String deletePost(Model model, HttpSession httpSession, @RequestParam Long id_producto) {
		User user = users.findByName((httpSession.getAttribute("user")).toString());
		Product product = products.findById(id_producto).orElseThrow();
		user.removeProduct(product);
		users.save(user);
		if(user!=null) {
			if(user.containsProduct(product)) {
				model.addAttribute("Carrito", true);
			}
		}
		model.addAttribute("product", product);
		model.addAttribute("user", httpSession.getValue("user"));
		return "show_product";
	}
	@GetMapping("/products/{id}/buy")
	public String buyProduct(Model model,HttpSession httpSession, @PathVariable long id) {
		Product product = products.findById(id).orElseThrow();
		User user = users.findByName((httpSession.getAttribute("user")).toString());
		user.addProduct(product);
		users.save(user);
		model.addAttribute("product", product);
		return "product_cart";
	}

}