package com.alixar.teamup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alixar.teamup.exception.ResourceNotFoundException;
import com.alixar.teamup.model.User;
import com.alixar.teamup.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        user.setName(userDetails.getName());
        user.setPhoto(userDetails.getPhoto());
        user.setDateOfBirth(userDetails.getDateOfBirth());
        user.setDescription(userDetails.getDescription());
        user.setValorations(userDetails.getValorations());
        user.setTeams(userDetails.getTeams());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        userRepository.delete(user);
    }
}
