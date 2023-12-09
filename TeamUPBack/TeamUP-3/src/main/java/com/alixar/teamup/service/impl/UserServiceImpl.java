package com.alixar.teamup.service.impl;

import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alixar.teamup.constants.ConstantesRequest;
import com.alixar.teamup.model.EventEntity;
import com.alixar.teamup.model.RequestEntity;
import com.alixar.teamup.model.TeamEntity;
import com.alixar.teamup.model.UserEntity;
import com.alixar.teamup.model.UserEvent;
import com.alixar.teamup.repository.UserRepository;
import com.alixar.teamup.service.UserService;

import jakarta.persistence.EntityExistsException;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserEntity getUserById(Long id) {
		Optional<UserEntity> userOptional = userRepository.findById(id);
		return userOptional.orElse(null);
	}

	@Override
	public void updateUser(UserEntity updatedUser) {
		Long userId = updatedUser.getId();
		Boolean userExits = userRepository.existsById(userId);

		if (userExits) {
			userRepository.save(updatedUser);
		} else {
			throw new RuntimeException("Usuario no encontrado con ID: " + userId);
		}
	}

	@Override
	public void deleteUser(Long id) {
		Boolean userExits = userRepository.existsById(id);

		if (userExits) {
			userRepository.deleteById(id);
		} else {
			throw new RuntimeException("Usuario no encontrado con ID: " + id);
		}
	}

	@Override
	public void createUser(UserEntity user) {
		boolean existUser = userRepository.existsById(user.getId());
		if (!existUser) {
			userRepository.save(user);
		}
		throw new EntityExistsException();

	}

	@Override
	public UserEntity loadUserByUsername(String username) {
		UserEntity user = userRepository.findByUsername(username);
		if (user != null) {
			return user;
		} else {
			throw new RuntimeException("Usuario no encontrado con Username: " + username);
		}
	}

	public boolean isCreator(UserEntity user, EventEntity event) {
		UserEntity creator = event.getCreator();
		if (creator.getId() == user.getId()) {
			return true;
		}
		return false;
	}

	public boolean isCreator(UserEntity user, TeamEntity team) {
		UserEntity creator = team.getCreator();
		if (creator.getId() == user.getId()) {
			return true;
		}
		return false;
	}

//	public boolean isLibre(UserEntity user, TeamEntity team) {
//		Set<UserEntity>miembros=team.getMiembros();
//		if(miembros.contains(user)) {
//			return false;			
//		}
//		return true;
//	}

	public boolean isLibre(UserEntity user, UserEvent event) {
		Set<UserEntity> participantes = event.getParticipants();
		if (participantes.contains(user)) {
			return false;
		}
		return true;
	}

	public TeamEntity abandonar(UserEntity user, TeamEntity team) throws FileNotFoundException {
		Set<UserEntity> miembros = team.getMiembros();
		if (miembros.contains(user)) {
			miembros.remove(user);
			return team;
		}
		throw new FileNotFoundException();
	}

	public UserEvent abandonar(UserEntity user, UserEvent event) throws FileNotFoundException {
		Set<UserEntity> participantes = event.getParticipants();
		if (participantes.contains(user)) {
			participantes.remove(user);
			return event;
		}
		throw new FileNotFoundException();
	}

	public TeamEntity unirme(UserEntity user, TeamEntity team) throws FileNotFoundException {
		Set<UserEntity> miembros = team.getMiembros();
		if (!miembros.contains(user)) {
			miembros.add(user);
			return team;
		}
		throw new EntityExistsException();
	}

	public UserEvent unirme(UserEntity user, UserEvent event) throws FileNotFoundException {
		Set<UserEntity> miembros = event.getParticipants();
		if (!miembros.contains(user)) {
			miembros.add(user);
			return event;
		}
		throw new EntityExistsException();
	}

	public Boolean validarRespuesta(UserEntity user, RequestEntity req, String respuesta) {
		UserEntity userDest = req.getDestinatario();
		UserEntity userOrig = req.getRemitente();

		if (user.getId() == userDest.getId()) {
			switch (respuesta) {
			case ConstantesRequest.ACEPTADA: {
				return true;
			}
			case ConstantesRequest.RECHAZADA: {
				return false;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + respuesta);
			}
		}
		throw new IllegalArgumentException("El id del destinatario: " + userDest.getId()
				+ " no concide con el id del usuario que responde: " + user.getId());
	}

	public UserEntity addFriend(UserEntity userDest,UserEntity userOri) {
		Set<UserEntity> amigosDest=userDest.getAmigos();
		Set<UserEntity> amigosOri=userOri.getAmigos();
		
		amigosDest.add(userOri);
		amigosOri.add(userDest);
		
		userDest.setAmigos(amigosDest);
		userOri.setAmigos(amigosOri);

		updateUser(userOri);
		updateUser(userDest);
		return null;
	}

}
