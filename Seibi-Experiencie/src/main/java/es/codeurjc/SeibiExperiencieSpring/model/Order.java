package es.codeurjc.SeibiExperiencieSpring.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User user;
	@ManyToMany
	private List<Product> products = new ArrayList<>();
	private boolean complete;
	private Date date;
	
	//Pago con tarjeta
	private String mail;
	private int cardNumber;
	private int CVV;
	
	public Order() {
	}

	public Order(User user, List<Product> products, boolean complete, Date date, String mail, int cNumber, int CVV) {
		super();
		this.user = user;
		this.products=products;
		this.complete=complete;
		this.date= date;
		this.mail=mail;
		this.cardNumber=cNumber;
		this.CVV= CVV;
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
	
	public List<Product> getProducts(){
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public int getCVV() {
		return CVV;
	}
	
	public void setCVV(int CVV) {
		this.CVV = CVV;
	}
	
	public Order orElseThrow() {
		// TODO Auto-generated method stub
		return null;
	}
}
