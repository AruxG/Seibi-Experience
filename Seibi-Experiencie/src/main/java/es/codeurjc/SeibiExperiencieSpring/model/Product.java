package es.codeurjc.SeibiExperiencieSpring.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.jdbc.Blob;

import java.awt.Image;
import java.util.List;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private String activities;
	private String city;
	private String time;
	private String image;
	private String description;
	@Lob
	@JsonIgnore
	private Blob imageFile;

	@OneToMany(mappedBy="product",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Comment> comments;
	
	public Product() {
	}

	public Product(String name, String activities, String city, String time, String image, String description) {
		super();
		this.name = name;
		this.activities = activities;
		this.city = city;
		this.time = time;
		this.image = image;
		this.description = description;
		
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
	
	public void setName() {
		this.name = name;
	}
	
	public String getActivities() {
		return activities;
	}
	
	public void setActivities() {
		this.activities = activities;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity() {
		this.city = city;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime() {
		this.time = time;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage() {
		this.image = image;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription() {
		this.description = description;
	}
}
