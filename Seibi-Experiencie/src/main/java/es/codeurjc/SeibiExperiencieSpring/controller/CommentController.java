package es.codeurjc.SeibiExperiencieSpring.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.SeibiExperiencieSpring.model.Comment;
import es.codeurjc.SeibiExperiencieSpring.model.Product;
import es.codeurjc.SeibiExperiencieSpring.model.User;
import es.codeurjc.SeibiExperiencieSpring.repository.CommentRepository;
import es.codeurjc.SeibiExperiencieSpring.repository.ProductRepository;
import es.codeurjc.SeibiExperiencieSpring.repository.UserRepository;

@Controller
@RequestMapping("/products/{id}/comments")
public class CommentController{
	
	@Autowired
	private CommentRepository comments;
	@Autowired
	private ProductRepository products;
	@Autowired
	private UserRepository users;
	
	@GetMapping("/")
	public Collection<Comment> getComments(){
		return comments.findAll();
	}
	
	@GetMapping("/create_comment")
	public String newComment(Model model,HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		
		User user = users.findByName(name).orElseThrow();

		model.addAttribute("usernombre", user.getName());		
		model.addAttribute("user", user.getName());	
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "create_comment";
	}
	
	@PostMapping("/comment_created")
	public String savedComment(Model model, @RequestParam String text,@PathVariable Long id,HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		
		User user = users.findByName(name).orElseThrow();

		model.addAttribute("usernombre", user.getName());		
		model.addAttribute("user", user.getName());	
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		Comment new_comment= new Comment(user, text, products.findById(id).orElseThrow());
		comments.save(new_comment);
		model.addAttribute("comment", new_comment);
		return "comment_created";
	}
	
	@PostMapping("/delete_comment")
	public String deleteComment(Model model, @RequestParam long id_comment, @PathVariable Long id,HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		
		User user = users.findByName(name).orElseThrow();

		model.addAttribute("usernombre", user.getName());		
		model.addAttribute("user", user.getName());	
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		Comment delete = comments.findById(id_comment);
		Product product = delete.getProduct();
		comments.delete(delete);
		model.addAttribute("product", product);
		return "delete_comment";
	}
}