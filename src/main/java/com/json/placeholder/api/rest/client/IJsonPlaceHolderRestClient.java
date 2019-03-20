package com.json.placeholder.api.rest.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;

public interface IJsonPlaceHolderRestClient<T> {
	public List<T> queryForList(String url,ParameterizedTypeReference<T> parameterizeTypeReference);
	public T queryForObject(String url, Class<T> classType);
}
