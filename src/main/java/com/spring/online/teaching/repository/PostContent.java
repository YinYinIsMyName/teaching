package com.spring.online.teaching.repository;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.online.teaching.models.User;
import com.spring.online.teaching.models.UserPostContent;

public interface PostContent extends JpaRepository<com.spring.online.teaching.models.PostContent, Integer> {

	

}
