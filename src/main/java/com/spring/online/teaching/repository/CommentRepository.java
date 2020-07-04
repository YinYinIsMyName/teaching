package com.spring.online.teaching.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.online.teaching.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	
}
