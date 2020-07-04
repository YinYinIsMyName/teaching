package com.spring.online.teaching.repository;

import java.util.Set;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.online.teaching.models.CreateSection;
import com.spring.online.teaching.models.User;

public interface UserPostContent extends JpaRepository<com.spring.online.teaching.models.UserPostContent, Integer> {
	
}
