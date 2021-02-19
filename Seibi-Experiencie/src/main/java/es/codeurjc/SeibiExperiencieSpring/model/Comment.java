package es.codeurjc.SeibiExperiencieSpring.model;

import java.sql.Date;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User user;
	private String text;
	
	@ManyToOne
	@JsonIgnore
	private Product product;
	
	public Comment() {
	}

	public Comment(User user, String text, Product product) {
		super();
		this.user = user;
		this.text = text;
		this.product = product;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText() {
		this.text = text;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct() {
		this.product = product;
	}

}
