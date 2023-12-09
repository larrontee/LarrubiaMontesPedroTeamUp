package com.alixar.teamup.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Builder
public class RequestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String tipo;

	@ManyToOne
	@JoinColumn(name="remitente_id", nullable=false)
	private UserEntity remitente;

	@ManyToOne
	@JoinColumn(name="destinatario_id", nullable=false)
	private UserEntity destinatario;

	
	@Column(nullable = false)
	private String estado;
	
	
	@ManyToMany
	@JoinTable(
	 name = "request_event", 
	 joinColumns = @JoinColumn(name = "request_id"), 
	 inverseJoinColumns = @JoinColumn(name = "event_id"))
	private Set<EventEntity> events;

	@ManyToMany
	@JoinTable(
	 name = "request_team", 
	 joinColumns = @JoinColumn(name = "request_id"), 
	 inverseJoinColumns = @JoinColumn(name = "team_id"))
	private Set<TeamEntity> teams;




}
