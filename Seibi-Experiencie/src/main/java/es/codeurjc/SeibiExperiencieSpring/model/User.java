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
	
	public User() {
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
		this.orders = new ArrayList<Order>();
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
}
