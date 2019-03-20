package com.json.placeholder.api.rest.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class JsonPlaceHolderRestClient<T> implements IJsonPlaceHolderRestClient<T>{
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<T> queryForList(String url, ParameterizedTypeReference<T> parameterizeTypeReference) {
		return null;
	}

	@Override
	public T queryForObject(String url, Class<T> classType) {
		// TODO Auto-generated method stub
		return null;
	}

}
