package com.sabanciuniv.payload;

public class EventPayload {
	
	private String eventName;
	private String location;
	private String date;
	private String topic;
	private String text;
	private String club;
	
	
	
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
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
	
	public EventPayload(String eventName, String location, String date, String topic, String text, String club) {
		super();
		this.eventName = eventName;
		this.location = location;
		this.date = date;
		this.topic = topic;
		this.text = text;
		this.club = club;
	}
	public EventPayload() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
