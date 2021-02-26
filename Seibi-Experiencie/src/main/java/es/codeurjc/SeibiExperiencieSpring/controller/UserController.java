package es.codeurjc.SeibiExperiencieSpring.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import es.codeurjc.SeibiExperiencieSpring.model.Comment;
import es.codeurjc.SeibiExperiencieSpring.model.User;
import es.codeurjc.SeibiExperiencieSpring.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository users;
	
	@GetMapping("/")
	public Collection<User> getUsers(){
		return users.findAll();
	}
	
	@GetMapping("/show_user")
	public String showUser(Model model, HttpSession httpSession){
		model.addAttribute("user",httpSession.getAttribute("name_user"));
		return "show_user";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@GetMapping("/signup")
	public String signUp(){
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signUp(Model model, HttpSession httpSession, @RequestParam String user, @RequestParam String password, @RequestParam String password2) {
		if(password.equals(password2)) {
			User new_User = new User(user,password);
			users.save(new_User);
			httpSession.setAttribute("name_user", new_User.getName());
			httpSession.setAttribute("user", new_User.getName());
			model.addAttribute("user",httpSession.getAttribute("name_user"));
			return "user_created";
		}else {
			model.addAttribute("error",true);
			return "signup";
		}
		
	}
}
