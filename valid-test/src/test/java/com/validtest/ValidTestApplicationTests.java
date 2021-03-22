package com.validtest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.validtest.model.ResponseModel;
import com.validtest.model.UserModel;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ValidTestApplicationTests {


	@Value("${server.port}")
	private String serverPort;
	
	private final String URL = "http://localhost:";
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void getAllUser() {
		
		ResponseEntity<ResponseModel> response = restTemplate.getForEntity(URL + serverPort +"/api/user/list-users" ,ResponseModel.class);
		ValidTestApplication.logger.info("Respuesta del servicio:{}", response.getBody());
		ValidTestApplication.logger.info("Respuesta del servicio:{}",response.getBody().getData());
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        
	}
	
	
	@Test
	void addUsuario() {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		UserModel u = new UserModel();
		u.setId(100);
		u.setName("Diego");
		u.setLastName("Rozo");
		
		HttpEntity<?> entity = new HttpEntity<UserModel>(u,httpHeaders);
		ResponseEntity<ResponseModel> response = restTemplate.exchange(URL + serverPort +"/api/user/save-user", HttpMethod.POST, entity, ResponseModel.class);
		ValidTestApplication.logger.info("Respuesta del servicio:{}", response.getBody().getData());
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
	
	@Test
	void updateUsuario() {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<?> entity = new HttpEntity<List<Integer>>(Arrays.asList(100,200),httpHeaders);
		ResponseEntity<ResponseModel> response = restTemplate.exchange(URL + serverPort +"/api/user/update-users", HttpMethod.PUT, entity, ResponseModel.class);
		ValidTestApplication.logger.info("Respuesta del servicio:{}", response.getBody().getData());
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
