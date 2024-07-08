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
import com.sabanciuniv.model.Users;
import com.sabanciuniv.payload.Id;
import com.sabanciuniv.payload.UserPayload;
import com.sabanciuniv.repository.UserRepo;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired UserRepo userRepo;
	private static final Logger logger = LoggerFactory.getLogger(CampusConnectApplication.class);
	
	
	@PostMapping("/geteuserid")
	public Users getUserID(@RequestBody Id id) {
		logger.info(LocalDateTime.now() + " User info is requested for user with ID: " + id.getId());
		
		List<Users> userList = userRepo.findByUserId(id.getId());
		Users user = new Users();
		user = userList.get(0);
		return user;
	}
	
	@PostMapping("/createuser")
	public Id createUser(@RequestBody UserPayload userToAdd) { //UserToAdd
		logger.info(LocalDateTime.now() + " User Requested adding new user to database with name: " + userToAdd.getName());
		
		
		Users user = userRepo.insert(new Users(userToAdd.getUserName(),userToAdd.getName(),userToAdd.getSurName(),userToAdd.getStudentClub(),userToAdd.getPassword(),userToAdd.getAge(),userToAdd.getFaculty()));
		
		logger.info("User added with Id: " + user.getUserId());
		
		Id userIdMessage = new Id(user.getUserId());
		return userIdMessage;
	}
	
	@GetMapping("/getallusers")
	public List<Users> getAllUsers(){
		return userRepo.findAll();
	}
	
}
