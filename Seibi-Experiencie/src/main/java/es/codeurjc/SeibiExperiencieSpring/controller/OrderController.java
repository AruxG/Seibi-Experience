package es.codeurjc.SeibiExperiencieSpring.controller;

import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.SeibiExperiencieSpring.model.Order;
import es.codeurjc.SeibiExperiencieSpring.model.User;
import es.codeurjc.SeibiExperiencieSpring.repository.OrderRepository;
import es.codeurjc.SeibiExperiencieSpring.repository.UserRepository;

@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderRepository orders;
	@Autowired 
	private UserRepository users;
	
	@GetMapping("/")
	public Collection<Order> getOrders(){
		return orders.findAll();
	}
	@GetMapping("/new")
	public String newOrder(Model model, HttpSession sesion) {
		User user = users.findByName((sesion.getAttribute("user")).toString());
		model.addAttribute("products",user.getProducts());
		return "payment_gateway";
	}
	@PostMapping("/realizar_pago")
	public String orderPayment(Model model, HttpSession sesion, @RequestParam String mail, @RequestParam int num_tarjeta, @RequestParam int CVV) {
		User user = users.findByName((sesion.getAttribute("user")).toString());
		if ((!mail.equals("")&&(mail.endsWith("@gmail.com")
				|| mail.endsWith("@gmail.es")
				|| mail.endsWith("@hotmail.com")
				|| mail.endsWith("@hotmail.es")))
				&&(num_tarjeta>=10000000&&num_tarjeta<=99999999)
				&&(CVV>=100&& CVV<=999)) 
		{
			Order newOrder= new Order(user,user.getProducts(),true, new java.util.Date(), mail, num_tarjeta, CVV );
			
			//limpiar productos del usuario para la siguiente compra
			
			
			user.getOrders().add(newOrder);
			users.save(user);
			orders.save(newOrder);
			return "order_completed";
		}
		else {
			model.addAttribute("products",user.getProducts());
			model.addAttribute("error", true);
			return "payment_gateway";
		}
	}
}
