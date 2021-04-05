package es.codeurjc.SeibiExperiencieSpring.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User usuario;
	private String text;
	
	@ManyToOne
	@JsonIgnore
	private Product product;
	
	public Comment() {
	}

	public Comment(User usuario, String text, Product product) {
		super();
		this.usuario = usuario;
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
		return usuario;
	}

	public void setUser(User user) {
		this.usuario = user;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

}
