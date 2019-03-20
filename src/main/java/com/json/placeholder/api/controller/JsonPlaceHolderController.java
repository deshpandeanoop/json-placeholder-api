package com.json.placeholder.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.json.placeholder.api.builder.JsonPlaceHolderRequestBuilder;
import com.json.placeholder.api.dto.response.TaskResponseDTO;
import com.json.placeholder.api.dto.response.UserResponseDTO;
import com.json.placeholder.api.service.IJsonPlaceHolderPlatform;

@RestController
public class JsonPlaceHolderController {
	@Autowired
	private IJsonPlaceHolderPlatform jsonPlaceHolderPlatform;

	@GetMapping("/users")
	public UserResponseDTO getUsers() {
		return jsonPlaceHolderPlatform.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public UserResponseDTO getUser(@PathVariable("userId") int id) {
		return jsonPlaceHolderPlatform.getUserById(id);
	}
	
	@GetMapping("/users/{userId}/tasks/{taskId}")
	public TaskResponseDTO getTasks(@PathVariable("userId") int userId,@PathVariable("taskId") int taskId) {
		return null;
	}
	
	@GetMapping("/users/{userId}/tasks")
	public TaskResponseDTO getUserTasks(@PathVariable("userId") int userId) {
		return jsonPlaceHolderPlatform.getUserTasks(
				JsonPlaceHolderRequestBuilder.buildTaskResquestDTO(userId, 0)
				);
	}
}
