package com.json.placeholder.api.builder;

import com.json.placeholder.api.dto.request.TaskRequestDTO;

public final class JsonPlaceHolderRequestBuilder {
	private JsonPlaceHolderRequestBuilder() {
		return;
	}
	
	public static TaskRequestDTO buildTaskResquestDTO(int userId,int taskId) {
		TaskRequestDTO taskRequestDTO = new TaskRequestDTO();
		taskRequestDTO.setUserId(userId);
		taskRequestDTO.setUserId(taskId);
		return taskRequestDTO;
	}
}
