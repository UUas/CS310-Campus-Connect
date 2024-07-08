package com.sabanciuniv.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sabanciuniv.model.Clubs;

public interface ClubRepo extends MongoRepository<Clubs, String> {
	public List<Clubs> findByClubID(String clubId);
}