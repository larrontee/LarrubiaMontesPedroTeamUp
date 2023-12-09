package com.alixar.teamup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alixar.teamup.model.RequestEntity;
import com.alixar.teamup.model.UserEntity;
@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long> {
}