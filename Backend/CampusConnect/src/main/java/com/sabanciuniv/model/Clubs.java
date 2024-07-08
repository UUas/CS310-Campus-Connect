package com.sabanciuniv.model;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Clubs {
    
    
    @Id
    private String clubID;
    
    private String clubName;
    
    private String clubPresident;
    private List<String> authorizedMembers;
    private List<String> clubEvents;

    // Constructor
    public Clubs(String clubName, String clubID, String clubPresident) {
        this.clubName = clubName;
        this.clubID = clubID;
        this.clubPresident = clubPresident;
        this.authorizedMembers = new ArrayList<>();
        this.clubEvents = new ArrayList<>();
    }
    
    
    
    public Clubs(String clubName, String clubPresident, List<String> authorizedMembers, List<String> clubEvents) {
		super();
		this.clubName = clubName;
		this.clubPresident = clubPresident;
		this.authorizedMembers = authorizedMembers;
		this.clubEvents = clubEvents;
	}



	public Clubs() {
    	
    }

    // Getter and Setter methods
    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
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

    public List<String> getClubEvents() {
        return clubEvents;
    }

    // Sample member functions
    public void addEvent(String event) {
        clubEvents.add(event);
    }

    public void addAuthorizedMember(String member) {
        authorizedMembers.add(member);
    }
}
