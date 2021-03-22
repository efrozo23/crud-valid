package com.validtest.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.validtest.model.UserModel;

@Service
public interface IUserDao {
	
	UserModel saveUser(UserModel dto);
	
	List<UserModel> getAllUser();
	
	int updateUsers(List<Integer> idUsers);
}
