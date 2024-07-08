package com.sabanciuniv.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sabanciuniv.model.Event;

public interface EventRepo extends MongoRepository<Event, String> {
	public List<Event> findByEventId(String eventId);
}
