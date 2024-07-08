package com.sabanciuniv.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sabanciuniv.CampusConnectApplication;
import com.sabanciuniv.model.Clubs;
import com.sabanciuniv.payload.Id;
import com.sabanciuniv.payload.ClubPayload;
import com.sabanciuniv.repository.ClubRepo;



@RestController
@RequestMapping("/club")
public class ClubController {

	@Autowired ClubRepo clubRepo;
	private static final Logger logger = LoggerFactory.getLogger(CampusConnectApplication.class);
	

	
	@PostMapping("/getclubid")
	public Clubs getClubID(@RequestBody Id id) {
		logger.info(LocalDateTime.now() + " Club info is requested for club with ID: " + id.getId());
		
		List<Clubs> clubList = clubRepo.findByClubID(id.getId());
		Clubs club = new Clubs();
		club = clubList.get(0);
		return club;
	}
	
	
	@PostMapping("/createclub")
	public Id createClub(@RequestBody ClubPayload clubToAdd) { //ClubToAdd
		logger.info(LocalDateTime.now() + " User Requested adding new club to database with name: " + clubToAdd.getClubName());
		
		
		Clubs club = clubRepo.insert(new Clubs(clubToAdd.getClubName(), clubToAdd.getClubPresident(), clubToAdd.getAuthorizedMembers(), clubToAdd.getClubEvents()));
		
		logger.info("Club added with Id: " + club.getClubID());
		
		Id clubIdMessage = new Id(club.getClubID());
		return clubIdMessage;
	}
	
	@GetMapping("/getallevents")
	public List<Clubs> getAllClubs(){
		return clubRepo.findAll();
	}
	
}
	
	