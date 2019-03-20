package com.json.placeholder.api.builder;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

import com.json.placeholder.api.dto.response.TaskResponseDTO;
import com.json.placeholder.api.dto.response.UserResponseDTO;
import com.json.placeholder.api.model.Task;
import com.json.placeholder.api.model.Temp1;
import com.json.placeholder.api.model.User;

public final class JsonPlaceHolderResponseBuilder {
	private JsonPlaceHolderResponseBuilder() {
		return;
	}
	public static UserResponseDTO buildUserResponseResponseDTO(List<User> users) {
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		userResponseDTO.setSize(!CollectionUtils.isEmpty(users)? users.size() : 0);
		userResponseDTO.setUsers(users);
		return userResponseDTO;
	}
	
	public static TaskResponseDTO buildTaskResponseDTO(List<Temp1> tasks) {
		TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
		taskResponseDTO.setSize(!CollectionUtils.isEmpty(tasks)?tasks.size():0);
		taskResponseDTO.setTemp(tasks);
		return taskResponseDTO;
	}
}
