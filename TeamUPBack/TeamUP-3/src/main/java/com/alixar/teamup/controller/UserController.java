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

import com.alixar.teamup.dto.CreateUserDTO;
import com.alixar.teamup.enums.UserRoles;
import com.alixar.teamup.model.RoleEntity;
import com.alixar.teamup.model.UserEntity;
import com.alixar.teamup.repository.UserRepository;
import com.alixar.teamup.service.impl.UserDetailsServiceImpl;
import com.alixar.teamup.service.impl.UserServiceImpl;

@RestController
//@RequestMapping("/")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	UserServiceImpl userService;


	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@Validated @RequestBody CreateUserDTO createUserDTO) {

		Set<RoleEntity> roles = createUserDTO.getRoles().stream()
				.map(role -> RoleEntity.builder().name(UserRoles.valueOf(role)).build()).collect(Collectors.toSet());

		UserEntity userEntity = UserEntity.builder().username(createUserDTO.getUsername())
				.password(passwordEncoder.encode(createUserDTO.getPassword())).email(createUserDTO.getEmail())
				.name(createUserDTO.getName()).surnames(createUserDTO.getSurnames())
				.birthdate(createUserDTO.getBirthdate()).roles(roles).build();

		userRepository.save(userEntity);

		return ResponseEntity.ok(userEntity);
	}

	@GetMapping("/misDatos")
	public UserEntity userDetails(Principal user) {
		return 	userService.loadUserByUsername(user.getName());
	}
//	@GetMapping("/misDatos")
//	public String userDetails(Principal user) {
//		return 	"Es problema de los objetos";
//	}
	

}
