package com.alixar.teamup.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class EventEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id") // Nombre de la columna que contiene el ID del creador en la tabla EventEntity
	private UserEntity creator;
//	@ManyToMany(mappedBy = "requests")
//	Set<RequestEntity> requests ;

	private String description;
	@Column(nullable = false)
	private LocalDate date;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String tipoEvent;
	@Column(nullable = false)
	private Boolean privado;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="location_id",nullable = false)
	private LocationEntity location;
}
