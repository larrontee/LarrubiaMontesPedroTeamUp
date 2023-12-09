package com.alixar.teamup.dto;

import java.time.LocalDate;
import java.util.Set;

import com.alixar.teamup.model.EventEntity;
import com.alixar.teamup.model.RoleEntity;
import com.alixar.teamup.model.TeamEntity;
import com.alixar.teamup.model.UserEntity;

import jakarta.persistence.Column;
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
public class RequestDTO {

	private Long id;
	private String tipo;
	private UserEntity remitente;
	private UserEntity destinatario;
	private String estado;
	private Long eventId;
	private Long teamId;

}

