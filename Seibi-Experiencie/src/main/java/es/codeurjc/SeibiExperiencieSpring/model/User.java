package es.codeurjc.SeibiExperiencieSpring.model;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private String password;
	
	@OneToMany
	private List<Order> orders;
	
	@OneToMany
	private List<Comment>comments;
}
