package com.example.eventapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventapp.model.Event;
import com.example.eventapp.service.EventService;

@RestController
public class EventController {

	@Autowired
	EventService eventService;
	
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
	
	@PutMapping("/events")
	public void updateEvent(@RequestBody Event event) {
		eventService.updateEvent(event);
	}
	
	@DeleteMapping("/events/{id}")
	public void deleteEvent(@PathVariable long id) {
		eventService.deleteEvent(id);
	}
	
	@PutMapping("/complete/{id}")
//	public ResponseEntity<Event> markEvent(@PathVariable long id) {
//		return ResponseEntity.ok(eventService.markEvent(id));
	public Event markEvent(@PathVariable long id) {
		return eventService.markEvent(id);
	}
}
