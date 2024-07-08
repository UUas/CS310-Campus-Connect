package com.sabanciuniv.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sabanciuniv.CampusConnectApplication;
import com.sabanciuniv.model.Event;
import com.sabanciuniv.payload.Id;
import com.sabanciuniv.payload.EventPayload;
import com.sabanciuniv.repository.EventRepo;



@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired EventRepo eventRepo;
	private static final Logger logger = LoggerFactory.getLogger(CampusConnectApplication.class);
	
	@GetMapping("/sayhello")
	public String sayHello() {
		return "Hello from Spring Rest!";
	}
	
	@PostMapping("/geteventid")
	public Event getEventID(@RequestBody Id id) {
		logger.info(LocalDateTime.now() + " Event info is requested for event with ID: " + id.getId());
		
		List<Event> eventList = eventRepo.findByEventId(id.getId());
		Event event = new Event();
		event = eventList.get(0);
		return event;
	}
	
	
	@PostMapping("/createevent")
	public Id createUser(@RequestBody EventPayload eventToAdd) { //UserToAdd
		logger.info(LocalDateTime.now() + " User Requested adding new event to database with name: " + eventToAdd.getEventName());
		
		
		Event event = eventRepo.insert(new Event(eventToAdd.getEventName(),eventToAdd.getLocation(),eventToAdd.getDate(),eventToAdd.getTopic(),eventToAdd.getText(),eventToAdd.getClub()));
		
		logger.info("User added with Id: " + event.getEventId());
		
		Id eventIdMessage = new Id(event.getEventId());
		return eventIdMessage;
	}
	
	@GetMapping("/getallevents")
	public List<Event> getAllEvents(){
		return eventRepo.findAll();
	}
	
	 @GetMapping("/geteventbyid/{id}")
	    public Event getEventById(@PathVariable("id") String id) {
	        logger.info(LocalDateTime.now() + " Event info is requested for event with ID: " + id);
	        
	        List<Event> eventList = eventRepo.findByEventId(id);
	        Event event = new Event();
	        if (!eventList.isEmpty()) {
	            event = eventList.get(0);
	        }
	        return event;
	    }
	
}
	
	