package com.alixar.teamup.service.impl;

import java.io.FileNotFoundException;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.alixar.teamup.model.TeamEntity;
import com.alixar.teamup.model.TeamEvent;

import jakarta.persistence.EntityExistsException;

@Service
public class TeamService {

	public boolean isLibre(TeamEntity team, TeamEvent event) {
		Set<TeamEntity> participantes = event.getTeams();
		if (participantes.contains(team)) {
			return false;
		}
		return true;
	}

	public TeamEvent abandonar(TeamEntity user, TeamEvent event) throws FileNotFoundException {
		Set<TeamEntity> participantes = event.getTeams();
		if (participantes.contains(user)) {
			participantes.remove(user);
			return event;
		}
		throw new FileNotFoundException();
	}

	public TeamEvent unirme(TeamEntity team, TeamEvent event) throws FileNotFoundException {
		Set<TeamEntity> participantes = event.getTeams();
		if (!participantes.contains(team)) {
			participantes.add(team);
			return event;
		}
		throw new EntityExistsException();
	}

	public boolean hacerPrivado(TeamEntity team) {
		boolean privado = team.getPrivado();
		if (privado) {
			return privado;
		} else if (!privado) {
			team.setPrivado(true);
			return team.getPrivado();
		}
		return false;
	}

}
