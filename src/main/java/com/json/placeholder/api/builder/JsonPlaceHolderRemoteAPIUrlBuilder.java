package com.json.placeholder.api.builder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-remote-api.properties")
public class JsonPlaceHolderRemoteAPIUrlBuilder {
	@Value("${json.placeholder.api.url}")
	private String jsonPlaceHolderRemoteAPIUrl;

	public String getUsersAPIUrl() {
		return new StringBuilder().append(jsonPlaceHolderRemoteAPIUrl).append("/users").toString();
	}
	
	public String getUsersByIdAPIUrl(int userId) {
		return new StringBuilder().append(jsonPlaceHolderRemoteAPIUrl).append("/users/").append(userId).toString();
	}
}
