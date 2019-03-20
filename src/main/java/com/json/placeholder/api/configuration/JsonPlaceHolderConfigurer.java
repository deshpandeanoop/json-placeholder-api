package com.json.placeholder.api.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestTemplate;

import com.json.placeholder.api.model.User;

@Configuration
public class JsonPlaceHolderConfigurer {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean("userListParameterizedTypeReference")
	public ParameterizedTypeReference<List<User>> getUserParameterizedTypeReference(){
		return new ParameterizedTypeReference<List<User>>() {};
	}
}
