package com.example.eventapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventapp.model.Event;
import com.example.eventapp.service.EventService;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;
	
	@GetMapping("/events")
	public List<Event> getEvents() {
		return eventService.getEvents();
	}
	
	@GetMapping("/events/{id}")
	public Event getEventById(@PathVariable long id) {
		return eventService.getEventById(id);
	}
	
	@PostMapping("/events")
	public void createEvent(@RequestBody Event event) {
		eventService.createEvent(event);
	}
}
