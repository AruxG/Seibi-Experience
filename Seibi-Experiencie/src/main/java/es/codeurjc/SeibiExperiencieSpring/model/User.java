package es.codeurjc.SeibiExperiencieSpring.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String passwordHash;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles= new ArrayList<String>();
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Orderz> orders = new ArrayList<Orderz>();
	
	@OneToMany(mappedBy="usuario",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Comment>comments = new ArrayList<Comment>();
	
	@ManyToMany
	private List<Product>products = new ArrayList<Product>();
	
	public User() {
	}

	public User(String name, String encodedPassword, String... roles) {
		this.name = name;
		this.passwordHash = encodedPassword;
		this.roles = List.of(roles);
	}

	
	public int sumTotal() {
		int resultado=0;
		for(Product p: this.products){
			resultado+= p.getPrice();
		}
		return resultado;
	}
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public List<String> getRoles() {
		return this.roles;
	}
	public void setRoles(List<String> roles) {
		this.roles=roles;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return passwordHash;
	}
	
	public void setPassword(String password) {
		this.passwordHash = password;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts( List<Product> products) {
		this.products = products;
	}
	
	public List<Orderz> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Orderz> orders) {
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
