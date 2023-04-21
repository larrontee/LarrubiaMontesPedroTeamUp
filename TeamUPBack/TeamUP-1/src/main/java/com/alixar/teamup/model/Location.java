package com.alixar.teamup.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    private String photo;

    private String description;

    @ElementCollection
    private List<Long> valorations;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Long category;

	public Location(Long id, String name, String location, String photo, String description, List<Long> valorations,
			Long category) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.photo = photo;
		this.description = description;
		this.valorations = valorations;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Long> getValorations() {
		return valorations;
	}

	public void setValorations(List<Long> valorations) {
		this.valorations = valorations;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

    
    
    
}

