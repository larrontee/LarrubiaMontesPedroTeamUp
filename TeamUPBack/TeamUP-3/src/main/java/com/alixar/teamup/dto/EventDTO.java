package com.alixar.teamup.dto;

import java.time.LocalDate;
import java.util.Set;

import com.alixar.teamup.model.LocationEntity;
import com.alixar.teamup.model.RoleEntity;
import com.alixar.teamup.model.TeamEntity;
import com.alixar.teamup.model.UserEntity;

import jakarta.persistence.Column;
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
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
	private Long id;
	private String name;
	private UserEntity creator;
	private String description;
	private LocalDate date; 
	private String address;
	private String tipoEvent;
	private Boolean privado;
	private LocationEntity location;
	private Set<UserEntity> participants;
	private UserEntity winner;
	private Set<TeamEntity> teams;
	private TeamEntity winnerTeam;
}
