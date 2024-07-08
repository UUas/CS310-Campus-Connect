package com.sabanciuniv.payload;

import java.util.List;

public class ClubPayload {
	private String clubName;
	private String clubPresident;
    private List<String> authorizedMembers;
    private List<String> clubEvents;
    
    
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getClubPresident() {
		return clubPresident;
	}
	public void setClubPresident(String clubPresident) {
		this.clubPresident = clubPresident;
	}
	public List<String> getAuthorizedMembers() {
		return authorizedMembers;
	}
	public void setAuthorizedMembers(List<String> authorizedMembers) {
		this.authorizedMembers = authorizedMembers;
	}
	public List<String> getClubEvents() {
		return clubEvents;
	}
	public void setClubEvents(List<String> clubEvents) {
		this.clubEvents = clubEvents;
	}
	public ClubPayload(String clubName, String clubPresident, List<String> authorizedMembers, List<String> clubEvents) {
		super();
		this.clubName = clubName;
		this.clubPresident = clubPresident;
		this.authorizedMembers = authorizedMembers;
		this.clubEvents = clubEvents;
	}
	public ClubPayload() {
		//default constructor
	}
	
	
    
    
}