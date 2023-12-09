package com.alixar.teamup.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alixar.teamup.constants.ConstantesRequest;
import com.alixar.teamup.model.EventEntity;
import com.alixar.teamup.model.RequestEntity;
import com.alixar.teamup.model.TeamEntity;
import com.alixar.teamup.repository.EventRepository;
import com.alixar.teamup.repository.RequestRepository;
import com.alixar.teamup.repository.TeamRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class RequestService {
	@Autowired
	RequestRepository requestRepository;

	@Autowired
	EventRepository eventRepository;
	@Autowired
	TeamRepository teamRepository;

	public RequestEntity createUserRequest(RequestEntity req) {
		Boolean existRequest = requestRepository.existsById(req.getId());
		if (!existRequest) {
			req.setEstado(ConstantesRequest.ENVIADA);
			return requestRepository.save(req);
		}
		throw new EntityExistsException();
	
	}

	public RequestEntity createEventRequest(RequestEntity req, Long idEvent) {
		Boolean existRequest = requestRepository.existsById(req.getId());
		if (!existRequest) {
			EventEntity event = eventRepository.findById(idEvent).get();
			Set<EventEntity> events = req.getEvents();
			events.add(event);
			req.setEvents(events);
			return requestRepository.save(req);
		}
		throw new EntityExistsException();
	}

	public RequestEntity createTeamRequest(RequestEntity req, Long idTeam) {
		Boolean existRequest = requestRepository.existsById(req.getId());
		if (!existRequest) {
			TeamEntity team= teamRepository.findById(idTeam).get();
			Set<TeamEntity> teams= req.getTeams();
			teams.add(team);
			req.setTeams(teams);
			return requestRepository.save(req);
		}
		throw new EntityExistsException();
	}
	
	public RequestEntity responderReq(RequestEntity req,String respuesta) {
		switch (respuesta) {
		case ConstantesRequest.ACEPTADA: {
			req.setEstado(respuesta);
			return req;
		}
		case ConstantesRequest.RECHAZADA: {
			req.setEstado(respuesta);
			return req;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + respuesta);
		}
	}
}
