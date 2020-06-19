package com.spring.online.teaching.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.online.teaching.models.Role;
import com.spring.online.teaching.payload.response.MessageResponse;

public interface RoleRespository extends JpaRepository<Role, Integer> {

	@Query("select new com.spring.online.teaching.payload.response.MessageResponse(u.name,r.name) from Role r inner join User u on u.role_id=r.role_id")
	List<MessageResponse> getinformation();

}
