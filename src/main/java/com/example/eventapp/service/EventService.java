package com.example.eventapp.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventapp.model.Event;
import com.example.eventapp.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	EventRepository eventRepo;
	
	private static final String PENDING="pending";
	private static final String COMPLETED="completed";
	private static final String OVERDUE="overdue";

	public List<Event> getEvents() {
		return eventRepo.findAll();
	}

	public Event getEventById(long id) {
		return eventRepo.findById(id).orElse(new Event());
	}
	
	public void createEvent(Event event) {
		event.setStatus(PENDING);
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
		event.setStatus(COMPLETED);
		return eventRepo.save(event);
	}
	
	public Map<String, List<Event>> getEventsGrouped() {
		List<Event> allEvents=eventRepo.findAll();
		LocalDate now=LocalDate.now();
		
		Map<String, List<Event>> groupedEvents=new HashMap<>();
		List<Event> pendingEvents=allEvents.stream()
										   .filter(event->event.getStatus().equals(PENDING) && event.getDate().isAfter(now))
										   .collect(Collectors.toList());
		//overdue
		List<Event> overdueEvents=allEvents.stream()
										  .filter(event->event.getStatus().equals(PENDING) && event.getDate().isBefore(now))
										  .collect(Collectors.toList());
		
		List<Event> completedEvents=allEvents.stream()
											 .filter(event->event.getStatus().equals(COMPLETED))
											 .collect(Collectors.toList());
		
		groupedEvents.put(PENDING,pendingEvents);
		groupedEvents.put(OVERDUE,overdueEvents);
		groupedEvents.put(COMPLETED, completedEvents);
		
		return groupedEvents;
	}
}
