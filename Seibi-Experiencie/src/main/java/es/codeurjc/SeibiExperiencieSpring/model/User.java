package es.codeurjc.SeibiExperiencieSpring.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Order> orders = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Comment>comments = new ArrayList<>();
	
	@ManyToMany
	private List<Product>products = new ArrayList<>();
	
	public User() {
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
		this.comments = new ArrayList<Comment>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts( List<Product> products) {
		this.products = products;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	
	public void removeProduct(Product p) {
		products.remove(p);
	}
	
	public boolean containsProduct(Product p) {
		return products.contains(p);
	}
}
