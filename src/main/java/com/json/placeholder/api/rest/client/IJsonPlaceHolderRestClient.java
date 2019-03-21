package com.json.placeholder.api.rest.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;

public interface IJsonPlaceHolderRestClient {
	public<T> List<T> queryForList(String url,ParameterizedTypeReference<List<T>> parameterizeTypeReference);
	public <T>T queryForObject(String url, Class<T> classType);
}
