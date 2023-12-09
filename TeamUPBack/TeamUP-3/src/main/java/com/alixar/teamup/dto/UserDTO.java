package com.alixar.teamup.dto;

import java.time.LocalDate;
import java.util.Set;

import com.alixar.teamup.model.EventEntity;
import com.alixar.teamup.model.RequestEntity;
import com.alixar.teamup.model.RoleEntity;
import com.alixar.teamup.model.TeamEntity;
import com.alixar.teamup.model.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Long id;
	private String username;
	private String password;
	private String name;
	private String surnames;
	private String email;
	private String profilePhoto;
	private LocalDate birthdate;
	private String description;
	private Set<RoleEntity> roles;
	private Set<UserEntity> amigos;
	private Set<TeamEntity> equipos;
	private Set<EventEntity> eventos;
	private Set<RequestEntity> solicitudesEnviadas;
	private Set<RequestEntity> solicitudesRecibidas;
}
