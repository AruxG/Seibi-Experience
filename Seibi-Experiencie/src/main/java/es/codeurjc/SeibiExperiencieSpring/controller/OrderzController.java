package es.codeurjc.SeibiExperiencieSpring.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import es.codeurjc.SeibiExperiencieSpring.model.Orderz;
import es.codeurjc.SeibiExperiencieSpring.model.Product;
import es.codeurjc.SeibiExperiencieSpring.model.User;
import es.codeurjc.SeibiExperiencieSpring.repository.OrderzRepository;
import es.codeurjc.SeibiExperiencieSpring.repository.UserRepository;

@Controller
@RequestMapping("/orders")
public class OrderzController {

	@Autowired
	private OrderzRepository orders;
	@Autowired
	private UserRepository users;

	@Value("${direccion}")
	private String localhost;
	
	@GetMapping("/")
	public Collection<Orderz> getOrders() {
		return orders.findAll();
	}

	@Cacheable
	@GetMapping("/new")
	public String newOrder(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();

		User user = users.findByName(name).orElseThrow();

		model.addAttribute("usernombre", user.getName());
		model.addAttribute("user", user.getName());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("products", user.getProducts());
		model.addAttribute("total", user.sumTotal());
		return "payment_gateway";
	}

	@CacheEvict
	@PostMapping("/realizar_pago")
	public String orderPayment(Model model, HttpServletRequest request, @RequestParam String mail,
			@RequestParam int num_tarjeta, @RequestParam int CVV) {
		String name = request.getUserPrincipal().getName();

		User user = users.findByName(name).orElseThrow();

		model.addAttribute("usernombre", user.getName());
		model.addAttribute("user", user.getName());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		List<String> datos = new ArrayList<String>();
		datos.add(mail);
		datos.add(""+num_tarjeta);
		datos.add(""+CVV);
		RestTemplate restTemplate = new RestTemplate();
		String url="http://"+localhost+":8080/payment";
		boolean datosCorrectos = restTemplate.postForObject(url, datos, boolean.class);
		System.out.println(datosCorrectos);
		int total = user.sumTotal();
		if (datosCorrectos) {
			Orderz newOrder = new Orderz(user, user.getProducts(), true, new java.util.Date(), mail, num_tarjeta, CVV,
					total);

			// limpiar productos del usuario para la siguiente compra

			orders.save(newOrder);
			model.addAttribute("id", newOrder.getId());
			user.setProducts(new ArrayList<Product>());
			users.save(user);
			return "order_completed";
		} else {
			model.addAttribute("total", user.sumTotal());
			model.addAttribute("products", user.getProducts());
			model.addAttribute("error", true);
			return "payment_gateway";
		}
	}

	@Cacheable
	@GetMapping("/export/pdf/{id}")
	public String exportPDF(Model model, HttpServletRequest request, @PathVariable Long id)
			throws IOException, UnknownHostException {
		
		String name = request.getUserPrincipal().getName();

		User user = users.findByName(name).orElseThrow();

		model.addAttribute("usernombre", user.getName());
		model.addAttribute("user", user.getName());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		
		Orderz orderz = orders.findById(id).orElseThrow();
		
		RestTemplate restTemplate = new RestTemplate();
		String url="http://"+localhost+":8080/pdf";
		boolean datosCorrectos = restTemplate.postForObject(url, orderz, boolean.class);
		if(datosCorrectos) {
			return "pdf_sent";
		}
		return "order_completed";
	}
}
