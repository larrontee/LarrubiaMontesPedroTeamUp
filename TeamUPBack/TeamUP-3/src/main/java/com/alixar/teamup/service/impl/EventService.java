package com.alixar.teamup.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.alixar.teamup.model.EventEntity;
import com.alixar.teamup.model.LocationEntity;
import com.alixar.teamup.repository.EventRepository;
import com.alixar.teamup.repository.RequestRepository;
import com.alixar.teamup.repository.TeamRepository;

@Service
public class EventService {
	@Autowired
	RequestRepository requestRepository;

	@Autowired
	EventRepository eventRepository;
	@Autowired
	TeamRepository teamRepository;

	public boolean hacerPrivado(EventEntity event) {
		boolean privado = event.getPrivado();
		if (privado) {
			return privado;
		} else if (!privado) {
			event.setPrivado(true);
			return event.getPrivado();
		}
		return false;
	}

	   public Set<EventEntity> getAllEvents(EventEntity event) {
	       Iterable<EventEntity> allEventsIterable = eventRepository.findAll(Sort.by(Sort.Direction.ASC, "startDate"));
	       Set<EventEntity> allEvents = new HashSet<>();
	       allEventsIterable.forEach(allEvents::add);
	       return allEvents;
	   }
	   
	   public Set<EventEntity> getEventosPorTipo(String tipo) {
	       Iterable<EventEntity> allEventsIterable = eventRepository.findByTipoEvent(tipo,Sort.by(Sort.Direction.ASC, "startDate"));
	       Set<EventEntity> allEvents = new HashSet<>();
	       allEventsIterable.forEach(allEvents::add);
	       return allEvents;
	   }

	   public Set<EventEntity> getEventosPorFecha(Date date) {
	       Iterable<EventEntity> allEventsIterable = eventRepository.findByDate(date,Sort.by(Sort.Direction.ASC, "startDate"));
	       Set<EventEntity> allEvents = new HashSet<>();
	       allEventsIterable.forEach(allEvents::add);
	       return allEvents;
	   }
	   
	   public Set<EventEntity> getEventosPorLocation(LocationEntity location) {
	       Iterable<EventEntity> allEventsIterable = eventRepository.findByLocation(location,Sort.by(Sort.Direction.ASC, "startDate"));
	       Set<EventEntity> allEvents = new HashSet<>();
	       allEventsIterable.forEach(allEvents::add);
	       return allEvents;
	   }


//	public Set<EventEntity> getAllEvents(EventEntity event, Pageable pageable) {
//		Page<EventEntity> eventPage = eventRepository.findAll(pageable);
//		Set<EventEntity> allEvents = new HashSet<>(eventPage.getContent());
//		return allEvents;
//	}

}
