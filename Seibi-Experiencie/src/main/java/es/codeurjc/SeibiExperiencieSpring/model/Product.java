package es.codeurjc.SeibiExperiencieSpring.model;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.awt.Image;
import java.util.List;

public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private List<String> activities;
	private String city;
	private String time;
	private Image image;
	private String description;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Comment> comments;
}
