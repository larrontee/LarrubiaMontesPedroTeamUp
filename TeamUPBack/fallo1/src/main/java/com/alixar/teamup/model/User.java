package com.alixar.teamup.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
	@Table(name = "users")
	public class User {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(unique = true, nullable = false)
	    private String username;
	    
	    @Column(nullable = false)
	    private String password;
	    
	    private String name;
	    
	    private String photo;
	    
	    @Temporal(TemporalType.DATE)
	    @Column(name = "date_of_birth")
	    private Date dateOfBirth;
	    
	    private String description;
	    
	    @ElementCollection
	    private List<Long> valorations;
	    
	    @ManyToMany
	    @JoinTable(name = "users_teams",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "team_id"))
	    private List<Team> teams;
	    
	    private String email;

	    // Constructor, getters, setters y otros métodos

}
