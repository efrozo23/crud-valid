package com.validtest.dao;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.validtest.ValidTestApplication;
import com.validtest.model.UserModel;
import com.validtest.repository.UserRepository;

@Repository
@org.springframework.transaction.annotation.Transactional
public class UserDao implements IUserDao {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserModel saveUser(UserModel dto) {
		ValidTestApplication.logger.info("INGRESO A PERSISTIR USUARIO");
		return userRepository.save(dto);
	}

	@Override
	public List<UserModel> getAllUser() {
		ValidTestApplication.logger.info("INGRESO A BUSCAR USUARIOS");
		return userRepository.findAll();
	}

	@Override
	public int updateUsers(List<Integer> idUsers) {
		ValidTestApplication.logger.info("INGRESO A ACTUALIZAR USUARIOS");
		
		ValidTestApplication.logger.info("REGISTROS MODIFICADOS: {}" ,idUsers);
		int r = userRepository.updateByEstado(idUsers);
		ValidTestApplication.logger.info("REGISTROS MODIFICADOS: {}" ,r);
		return r;
		
	}

}
