
package com.json.placeholder.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.json.placeholder.api.builder.JsonPlaceHolderResponseBuilder;
import com.json.placeholder.api.dto.request.TaskRequestDTO;
import com.json.placeholder.api.dto.request.UserRequestDTO;
import com.json.placeholder.api.dto.response.TaskResponseDTO;
import com.json.placeholder.api.dto.response.UserResponseDTO;
import com.json.placeholder.api.model.User;
import com.json.placeholder.api.repository.IUserRepository;
import com.json.placeholder.api.rest.client.IJsonPlaceHolderRestClient;

@Service
public class JsonPlaceHolderPlatform implements IJsonPlaceHolderPlatform{
	@Autowired @Qualifier("userListParameterizedTypeReference")
	private ParameterizedTypeReference<List<User>> userParameterizedTypeReference;
	
	/* Makes Rest Call synchronously*/
	@Autowired @Qualifier("sync")
	private IJsonPlaceHolderRestClient jsonPlaceHolderRestClient;
	
	@Autowired
	private IUserRepository userRepository;
	/**
	 * Fetches data from remote API, database, and forms response by concatinating two listss
	 */
	@Override
	public UserResponseDTO getUsers() {
		List<User> users = new ArrayList<>();
		users.addAll(userRepository.findAll());
		users.addAll(jsonPlaceHolderRestClient.queryForList("https://jsonplaceholder.typicode.com/users",
				userParameterizedTypeReference));
		return JsonPlaceHolderResponseBuilder.buildUserResponseResponseDTO(users);
	}
	/**
	 * Returns User details for given Id.
	 * First check in database, If not present, calls remote API.
	 */
	@Override
	public UserResponseDTO getUserById(int id) {
		User user = userRepository.findById(id).orElse(null);
		if (null == user) {
			return JsonPlaceHolderResponseBuilder
					.buildUserResponseResponseDTO(Collections.singletonList(jsonPlaceHolderRestClient
							.queryForObject("https://jsonplaceholder.typicode.com/users/" + id, User.class)));
		}
		return JsonPlaceHolderResponseBuilder.buildUserResponseResponseDTO(Collections.singletonList(user));
	}
	/**
	 * Persists/Saves persons in database.
	 */
	@Override
	public UserResponseDTO saveUsers(UserRequestDTO userRequestDTO) {
		return JsonPlaceHolderResponseBuilder
				.buildUserResponseResponseDTO(userRepository.saveAll(userRequestDTO.getUsers()));
	}

	@Override
	public TaskResponseDTO getUserTasks(TaskRequestDTO taskRequestDTO) {
		return null;
	}

}
