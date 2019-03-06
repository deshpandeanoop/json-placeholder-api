package com.json.placeholder.api.service;


import com.json.placeholder.api.dto.request.TaskRequestDTO;
import com.json.placeholder.api.dto.response.TaskResponseDTO;
import com.json.placeholder.api.dto.response.UserResponseDTO;
/**
 * 
 *Service contract for JsonPlaceHolder API
 *
 */
public interface IJsonPlaceHolderPlatform {
	public UserResponseDTO getUsers();
	public TaskResponseDTO getTask(TaskRequestDTO taskRequestDTO);
}
