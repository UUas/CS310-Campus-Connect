package com.sabanciuniv.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sabanciuniv.model.Users;

public interface UserRepo extends MongoRepository<Users, String> {
	public List<Users> findByUserId(String userId);
}
