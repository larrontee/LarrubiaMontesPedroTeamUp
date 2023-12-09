package com.alixar.teamup.controller;

import java.security.Principal;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alixar.teamup.constants.ConstantesRequest;
import com.alixar.teamup.dto.CreateUserDTO;
import com.alixar.teamup.dto.RequestDTO;
import com.alixar.teamup.enums.UserRoles;
import com.alixar.teamup.model.RequestEntity;
import com.alixar.teamup.model.RoleEntity;
import com.alixar.teamup.model.UserEntity;
import com.alixar.teamup.repository.UserRepository;
import com.alixar.teamup.service.impl.RequestService;
import com.alixar.teamup.service.impl.UserDetailsServiceImpl;
import com.alixar.teamup.service.impl.UserServiceImpl;

@RestController
//@RequestMapping("/")
@CrossOrigin(origins = "*")
public class RequetsController {
	
	@Autowired
	RequestService requestService;

	public ResponseEntity<?> createRequest(RequestDTO req) {
		String tipo = req.getTipo().toString();
		Long eventId=req.getEventId();
		Long teamId=req.getTeamId();
		RequestEntity request = RequestEntity.builder().tipo(req.getTipo()).remitente(req.getRemitente())
				.destinatario(req.getDestinatario()).estado(req.getEstado()).build();
		
		switch (tipo) {
		case ConstantesRequest.USER: {
			requestService.createUserRequest(request);
			return ResponseEntity.ok(request);

		}
		case ConstantesRequest.EVENT: {
			requestService.createEventRequest(request,eventId);
			return ResponseEntity.ok(request);
		}
		case ConstantesRequest.TEAM: {
			requestService.createTeamRequest(request,teamId);
			return ResponseEntity.ok(request);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipo);
		}

	}

}
