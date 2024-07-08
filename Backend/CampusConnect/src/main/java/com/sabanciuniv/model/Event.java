package com.sabanciuniv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("Event")
public class Event {
	
	@Id private String eventId;
	
	private String eventName;
	private String location;
	private String date;
	private String topic;
	private String text;
	
	private String club;

	
	
	public Event(String eventName, String location, String date, String topic, String text, String club) {
		super();
		this.eventName = eventName;
		this.location = location;
		this.date = date;
		this.topic = topic;
		this.text = text;
		this.club = club;
	}
	

	public Event() {
		// TODO Auto-generated constructor stub
	}



	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}



	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", location=" + location + ", date=" + date
				+ ", topic=" + topic + ", text=" + text + ", club=" + club + "]";
	}
	
	
	
}
