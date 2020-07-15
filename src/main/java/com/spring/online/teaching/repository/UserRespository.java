package com.spring.online.teaching.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.online.teaching.models.User;
import com.spring.online.teaching.models.UserPostContent;
import com.spring.online.teaching.payload.response.RoleResponse;

public interface UserRespository extends JpaRepository<User, Integer> {

	Optional<User> findByName(String name);

	@Query("select new com.spring.online.teaching.payload.response.RoleResponse (u.userId,u.name,r.name,u.password) from User u inner join Role r on r.role_id=u.role_id where u.name=:username")
	RoleResponse findByUsername(@Param("username") String username);

	
}
