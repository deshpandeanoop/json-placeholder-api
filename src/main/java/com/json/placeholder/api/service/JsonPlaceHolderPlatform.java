package com.json.placeholder.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.json.placeholder.api.builder.JsonPlaceHolderResponseBuilder;
import com.json.placeholder.api.dto.request.TaskRequestDTO;
import com.json.placeholder.api.dto.response.TaskResponseDTO;
import com.json.placeholder.api.dto.response.UserResponseDTO;
import com.json.placeholder.api.model.User;

@Service
public class JsonPlaceHolderPlatform implements IJsonPlaceHolderPlatform{
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public UserResponseDTO getUsers() {
		return JsonPlaceHolderResponseBuilder.buildUserResponseResponseDTO(
				getResponseFromRemoteAPI("https://jsonplaceholder.typicode.com/users",new User()));
	}
	
	@Override
	public TaskResponseDTO getTask(TaskRequestDTO taskRequestDTO) {
		return null;
	}
	
	private <T> List<T> getResponseFromRemoteAPI(final String url,T entity){
		ResponseEntity<List<T>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<T>>() {
		});
		return responseEntity.getBody();
	}
}
