package com.json.placeholder.api.rest.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component("sync")
public class JsonPlaceHolderSyncRestClient implements IJsonPlaceHolderRestClient{
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public<T> List<T> queryForList(String url, ParameterizedTypeReference<List<T>> parameterizeTypeReference) {
		return restTemplate.exchange(url, HttpMethod.GET, null, parameterizeTypeReference).getBody();
	}

	@Override
	public<T> T queryForObject(String url, Class<T> responseType){
		return restTemplate.getForObject(url, responseType);
	}

}
