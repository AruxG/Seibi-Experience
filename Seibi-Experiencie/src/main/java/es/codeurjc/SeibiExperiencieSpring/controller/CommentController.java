package es.codeurjc.SeibiExperiencieSpring.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.SeibiExperiencieSpring.model.Comment;
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
	public String newComment(Model model) {
		return "create_comment";
	}
	@PostMapping("/comment_created")
	public String savedComment(Model model,HttpSession httpSession, @RequestParam String text,@PathVariable Long id) {
		Comment new_comment= new Comment(users.findByName((httpSession.getAttribute("user")).toString()), text, products.findById(id).orElseThrow());
		comments.save(new_comment);
		model.addAttribute("comment", new_comment);
		return "comment_created";
	}
}