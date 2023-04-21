package com.alixar.teamup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alixar.teamup.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
