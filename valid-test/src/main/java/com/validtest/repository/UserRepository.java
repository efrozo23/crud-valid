package com.validtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.validtest.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
	
	@Modifying
	@Query(value = "update usuarios u set u.status = 1 where u.id in ( :id ) ",nativeQuery = true)
	int updateByEstado(@Param("id") List<Integer> ids);

}
