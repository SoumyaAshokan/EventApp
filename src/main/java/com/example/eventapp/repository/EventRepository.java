package com.example.eventapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eventapp.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Long>{
	
}
