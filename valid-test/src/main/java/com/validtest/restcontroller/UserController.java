package com.validtest.restcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.validtest.ValidTestApplication;
import com.validtest.dao.IUserDao;
import com.validtest.model.ResponseModel;
import com.validtest.model.UserModel;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserDao iuserDao;
	
	@PostMapping("/save-user")
	public ResponseEntity<Object> saveUser(@RequestBody UserModel dto){
		
		ResponseModel response= new ResponseModel();
		try {
			ValidTestApplication.logger.info("INGRESO A PERSISTIR USUARIO: {}",dto.getName());
			UserModel userR = iuserDao.saveUser(dto);
			response.setMessage("USUARIO CREADO");
			response.setData(Arrays.asList(userR));
			return new ResponseEntity<>(response,HttpStatus.CREATED);
		} catch (Exception e) {
			response.setMessage("ERROR AL CREAR USUARIO");
			response.setData(Arrays.asList(e.getStackTrace()));
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/list-users")
	public ResponseEntity<Object> getAllUsers(){
		ResponseModel response= new ResponseModel();
		try {
			List<UserModel> allUsers = iuserDao.getAllUser();
			ValidTestApplication.logger.info("USUARIOS ENCONTRADOS: {}",allUsers.size());
			response.setMessage("OK");
			response.setData(allUsers);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage("ERROR");
			response.setData(Arrays.asList(e.getStackTrace()));
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update-users")
	public ResponseEntity<Object> updateUsers(@RequestBody List<Integer> idUsers){
		ResponseModel response= new ResponseModel();
		try {
			
			ValidTestApplication.logger.info("USUARIOS POR ACTUALIZAR: {}",idUsers.toString());
			response.setMessage("USUARIOS PROCESADOS");
			int r = iuserDao.updateUsers(idUsers);
			response.setData(Arrays.asList(r));
			return new ResponseEntity<>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage("ERROR");
			response.setData(Arrays.asList(e.getStackTrace()));
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
