package com.alixar.teamup.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    @ManyToMany(mappedBy = "teams")
    private List<User> captain;

    private String photo;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    private String description;

    @ElementCollection
    private List<Long> valorations;

	public Team(Long id, String name, String category, List<User> captain, String photo, Date dateOfCreation,
			String description, List<Long> valorations) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.captain = captain;
		this.photo = photo;
		this.dateOfCreation = dateOfCreation;
		this.description = description;
		this.valorations = valorations;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<User> getCaptain() {
		return captain;
	}

	public void setCaptain(List<User> captain) {
		this.captain = captain;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
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

    
    
}
