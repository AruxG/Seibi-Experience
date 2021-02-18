package es.codeurjc.SeibiExperiencieSpring.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private String user;
	private String text;
	
	@ManyToOne
	@JsonIgnore
	private Product product;
	
}
