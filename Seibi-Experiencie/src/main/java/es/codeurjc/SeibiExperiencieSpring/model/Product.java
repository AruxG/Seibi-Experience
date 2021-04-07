package es.codeurjc.SeibiExperiencieSpring.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private String activities;
	private String city;
	private String time;
	private String image;
	private String description;
	private int price;
	@Lob
	@JsonIgnore
	private Blob imageFile;

	@OneToMany(mappedBy="product",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Comment> comments = new ArrayList<Comment>();
	
	
	public Product() {
	}

	public Product(String name, String activities, String city, String time, Blob imageFile, String description,int price ) {
		super();
		this.name = name;
		this.activities = activities;
		this.city = city;
		this.time = time;
		this.imageFile = imageFile;
		this.description = description;
		this.price = price;
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
	
	public String getActivities() {
		return activities;
	}
	
	public void setActivities(String activities) {
		this.activities = activities;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public Blob getImage() {
		return imageFile;
	}
	
	public void setImage(Blob imageFile) {
		this.imageFile = imageFile;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}


}
