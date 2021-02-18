package es.codeurjc.SeibiExperiencieSpring.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private User user;
	@ManyToMany
	private List<Product> products;
	private Date date;
	
	//Pago con tarjeta
	private String mail;
	private String cardNumber;
	private int CVV;
	
}
