package com.json.placeholder.api.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.json.placeholder.api.builder.JsonPlaceHolderResponseBuilder;
import com.json.placeholder.api.dto.request.TaskRequestDTO;
import com.json.placeholder.api.dto.response.TaskResponseDTO;
import com.json.placeholder.api.dto.response.UserResponseDTO;
import com.json.placeholder.api.model.Task;
import com.json.placeholder.api.model.Temp1;
import com.json.placeholder.api.model.User;

@Service
public class JsonPlaceHolderPlatform implements IJsonPlaceHolderPlatform{
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	@Qualifier("userListParameterizedTypeReference")
	private ParameterizedTypeReference<List<User>> userParameterizedTypeReference;
	@Override
	public UserResponseDTO getUsers() {
		return JsonPlaceHolderResponseBuilder.buildUserResponseResponseDTO(
				getResponseListFromRemoteAPI("https://jsonplaceholder.typicode.com/users",userParameterizedTypeReference));
	}
	
	@Override
	public UserResponseDTO getUserById(int id) {
		return JsonPlaceHolderResponseBuilder
				.buildUserResponseResponseDTO(Collections.singletonList(getResponseObjectFromRemoteAPI(
						"https://jsonplaceholder.typicode.com/users/"+id, User.class)));
	}
	
	private <T> List<T> getResponseListFromRemoteAPI(final String url,ParameterizedTypeReference<List<T>> parameterizeReference){
		ResponseEntity<List<T>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,parameterizeReference);
		return responseEntity.getBody();
	}
	
	private <T> T getResponseObjectFromRemoteAPI(final String url,Class<T> claszz) {
		return restTemplate.getForObject(url, claszz);
	}

	@Override
	public TaskResponseDTO getUserTasks(TaskRequestDTO taskRequestDTO) {
		ResponseEntity<List<Temp1>> responseEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/users/"+taskRequestDTO.getUserId()+"/todos", HttpMethod.GET, null, new ParameterizedTypeReference<List<Temp1>>() {
		});
		return JsonPlaceHolderResponseBuilder.buildTaskResponseDTO(responseEntity.getBody());
	}
}
