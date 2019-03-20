package com.json.placeholder.api.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.json.placeholder.api.model.User;

public class JsonPlaceHolderPlatformExternalTask implements IJsonPlaceHolderPlatformExternalTask{
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
