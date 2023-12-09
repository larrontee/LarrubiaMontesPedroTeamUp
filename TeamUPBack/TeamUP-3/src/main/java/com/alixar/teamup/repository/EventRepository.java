package com.alixar.teamup.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alixar.teamup.model.EventEntity;
import com.alixar.teamup.model.LocationEntity;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
	Set<EventEntity> findByTipoEvent(String tipo, Sort sort);
	Set<EventEntity> findByDate(Date date, Sort sort);
	Set<EventEntity> findByLocation(LocationEntity location, Sort sort);
}