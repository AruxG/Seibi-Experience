package es.codeurjc.SeibiExperiencieSpring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.SeibiExperiencieSpring.model.Comment;
import es.codeurjc.SeibiExperiencieSpring.repository.CommentRepository;

@RestController
@RequestMapping("/comments")
public class CommentController{
	
	@Autowired
	private CommentRepository comments;
	
	@GetMapping("/")
	public Collection<Comment> getComments(){
		return comments.findAll();
	}
}