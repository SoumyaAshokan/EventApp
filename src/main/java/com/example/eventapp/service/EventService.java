package com.example.eventapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventapp.model.Event;
import com.example.eventapp.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepo;

	public List<Event> getEvents() {
		return eventRepo.findAll();
	}

	public Event getEventById(long id) {
		return eventRepo.findById(id).orElse(new Event());
	}
	public void createEvent(Event event) {
		eventRepo.save(event);
	}


}
