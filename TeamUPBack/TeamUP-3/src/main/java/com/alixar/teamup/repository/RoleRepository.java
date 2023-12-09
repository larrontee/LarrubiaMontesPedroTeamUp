package com.alixar.teamup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alixar.teamup.model.RoleEntity;
import com.alixar.teamup.model.UserEntity;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}