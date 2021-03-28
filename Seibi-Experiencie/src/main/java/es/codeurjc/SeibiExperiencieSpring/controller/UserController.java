package es.codeurjc.SeibiExperiencieSpring.controller;


import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.password.PasswordEncoder;

import es.codeurjc.SeibiExperiencieSpring.model.Product;
import es.codeurjc.SeibiExperiencieSpring.model.User;
import es.codeurjc.SeibiExperiencieSpring.repository.ProductRepository;
import es.codeurjc.SeibiExperiencieSpring.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository users;
	@Autowired
	private ProductRepository products;
	@Autowired
	private PasswordEncoder passwordEncoder;
	 

	@GetMapping("/show_user")
	public String showUser(Model model,HttpServletRequest request){
		String name = request.getUserPrincipal().getName();
		
		User user = users.findByName(name).orElseThrow();

		model.addAttribute("username", user.getName());		
		model.addAttribute("user", user.getName());		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		if( user!=null){
		model.addAttribute("orders",user.getOrders());
		}
		return "show_user";
	}
	
	
	@GetMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 model.addAttribute("token", token.getToken()); 
		 
		return "login";
	}
	/*
	@PostMapping("/login")
	public String login(Model model,HttpSession httpSession, @RequestParam String user, @RequestParam String password){
		
		if(users.findByName(user)!=null&& users.findByName(user).getPassword().equals(password)){
			httpSession.setAttribute("name_user", user);
			httpSession.setAttribute("user", user);
			model.addAttribute("user",httpSession.getAttribute("name_user"));
			return "user_loged";
		}else {
			if(users.findByName(user)==null) {
				model.addAttribute("usedName", user);
			}else {
				model.addAttribute("error",true);
			}
			return "login";
		}
	}
	
	*/
	
	@GetMapping("/user_loged")
	public String userLoged(Model model, HttpServletRequest request) {

		String name = request.getUserPrincipal().getName();
		
		User user = users.findByName(name).orElseThrow();

		model.addAttribute("username", user.getName());		
		model.addAttribute("user", user.getName());		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "user_loged";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		return "user_unloged";
	}
	@GetMapping("/signup")
	public String signUp(){
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signUp(Model model, @RequestParam String user, @RequestParam String password, @RequestParam String password2) {
		Optional<User> userold = users.findByName(user);
		if (userold.isPresent() || user.equals("")) {
			model.addAttribute("error2",true);
			return "signup";
		}else {
			if(password.equals(password2)) {
				User new_User = new User(user,passwordEncoder.encode(password),"USER");
				users.save(new_User);
				model.addAttribute("user",new_User.getName());
				return "user_created";
			}else {
				model.addAttribute("error",true);
				return "signup";
			}
		}
	}
	
	@GetMapping("/carrito")
	public String show_carrito(Model model,HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		
		User user = users.findByName(name).orElseThrow();

		model.addAttribute("username", user.getName());		
		model.addAttribute("user", user.getName());		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("products",user.getProducts());
		int total=user.sumTotal();
		if (total>0)
			model.addAttribute("total", total);
		return "carrito";
	}
	
	@PostMapping("/carrito")
	public String deleteProduct(Model model, @RequestParam Long id_producto,HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		
		User user = users.findByName(name).orElseThrow();

		model.addAttribute("username", user.getName());		
		model.addAttribute("user", user.getName());		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		Product p = products.findById(id_producto).orElseThrow();
		user.removeProduct(p);
		users.save(user);
		model.addAttribute("products",user.getProducts());
		int total=user.sumTotal();
		if (total>0)
			model.addAttribute("total", total);
		return "carrito";
	}
}
