package com.json.placeholder.api.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.json.placeholder.api.model.User;
import com.json.placeholder.api.repository.IUserRepository;

public class JsonPlaceHolderPlatformInternalTask implements IJsonPlaceHolderPlatformInternalTask{
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> saveUsers(List<User> users) {
		return userRepository.saveAll(users);
	}

}
