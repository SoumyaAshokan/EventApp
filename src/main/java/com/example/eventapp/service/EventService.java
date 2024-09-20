package com.example.eventapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventapp.model.Event;
import com.example.eventapp.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	EventRepository eventRepo;

	public List<Event> getEvents() {
		return eventRepo.findAll();
	}

	public Event getEventById(long id) {
		return eventRepo.findById(id).orElse(new Event());
	}
	
	public void createEvent(Event event) {
		event.setStatus("pending");
		eventRepo.save(event);
	}

	public void updateEvent(Event event) {
		eventRepo.save(event);	
	}

	public void deleteEvent(long id) {
		eventRepo.deleteById(id);
	}

	public Event markEvent(long id) {
		Event event= eventRepo.findById(id).orElse(new Event());
		event.setStatus("completed");
		return eventRepo.save(event);
	}
}
