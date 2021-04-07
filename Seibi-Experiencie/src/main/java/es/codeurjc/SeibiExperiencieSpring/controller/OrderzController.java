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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/")
	public Collection<Orderz> getOrders() {
		return orders.findAll();
	}

	@GetMapping("/new")
	public String newOrder(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();

		User user = users.findByName(name).orElseThrow();

		model.addAttribute("username", user.getName());
		model.addAttribute("user", user.getName());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("products", user.getProducts());
		model.addAttribute("total", user.sumTotal());
		return "payment_gateway";
	}

	@PostMapping("/realizar_pago")
	public String orderPayment(Model model, HttpServletRequest request, @RequestParam String mail,
			@RequestParam int num_tarjeta, @RequestParam int CVV) {
		String name = request.getUserPrincipal().getName();

		User user = users.findByName(name).orElseThrow();

		model.addAttribute("username", user.getName());
		model.addAttribute("user", user.getName());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		if ((!mail.equals("") && (mail.endsWith("@gmail.com") || mail.endsWith("@gmail.es")
				|| mail.endsWith("@hotmail.com") || mail.endsWith("@hotmail.es")))
				&& (num_tarjeta >= 10000000 && num_tarjeta <= 99999999) && (CVV >= 100 && CVV <= 999)) {
			int total = user.sumTotal();
			Orderz newOrder = new Orderz(user, user.getProducts(), true, new java.util.Date(), mail, num_tarjeta, CVV,
					total);

			// limpiar productos del usuario para la siguiente compra

			orders.save(newOrder);
			model.addAttribute("id", newOrder.getId());
			user.setProducts(new ArrayList<Product>());
			users.save(user);
			return "order_completed";
		} else {
			model.addAttribute("products", user.getProducts());
			model.addAttribute("error", true);
			return "payment_gateway";
		}
	}

	@GetMapping("/export/pdf/{id}")
	public String exportPDF(Model model, HttpServletRequest request, @PathVariable Long id)
			throws IOException, UnknownHostException {
		String name = request.getUserPrincipal().getName();

		User user = users.findByName(name).orElseThrow();

		model.addAttribute("username", user.getName());
		model.addAttribute("user", user.getName());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		
		Orderz orderz = orders.findById(id).orElseThrow();
		String host = "127.0.0.1";
		int port = 6666;
		Socket socket = new Socket(host, port);
		OutputStream out = socket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		InputStream in = socket.getInputStream();
		
		PrintWriter escribirServidor =new PrintWriter(socket.getOutputStream(),true);
		escribirServidor.println(orderz.getUser().getName());
		escribirServidor.println(orderz.getMail());
		List<Product> products = orderz.getProducts();
		escribirServidor.println(products.size());
		for(Product p:products) {
			escribirServidor.println(p.getName());
			escribirServidor.println(p.getActivities());
			escribirServidor.println(p.getDescription());
			escribirServidor.println(p.getPrice());
		}
		escribirServidor.println(orderz.getTotal());
		// Envío y recepción de información
		oos.writeObject(orderz);
		System.out.println("Recibo enviado al servicio");
		oos.close();
		out.close();
		in.close();
		socket.close();
		return "order_completed";
	}
}
