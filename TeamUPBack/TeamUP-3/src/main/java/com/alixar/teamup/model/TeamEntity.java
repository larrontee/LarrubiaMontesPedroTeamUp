package com.alixar.teamup.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
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
public class TeamEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String surnames;

	@Column(nullable = false)
	private String email;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id") // Nombre de la columna que contiene el ID del creador en la tabla EventEntity
	private UserEntity creator;

	private String profilePhoto;

	@Column(nullable = false)
	private LocalDate foundation;

	private String description;

	@ManyToMany
	@JoinTable(name = "miembros", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<UserEntity> miembros;
	@Column(nullable = false)
	private Boolean privado;
}
