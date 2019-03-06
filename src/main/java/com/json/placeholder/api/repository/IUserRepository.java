package com.json.placeholder.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.json.placeholder.api.model.User;

public interface IUserRepository extends JpaRepository<User, Integer>{
	
}
