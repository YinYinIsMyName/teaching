package com.spring.online.teaching.security.services;

import java.io.Console;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.online.teaching.models.Comment;
import com.spring.online.teaching.payload.request.CommentRequest;
import com.spring.online.teaching.repository.CommentRepository;

@Service
public class CommentServiceImpl {

	@Autowired
	CommentRepository commentrepository;

	@Transactional
	public void addcomments(long postId, long userId, CommentRequest request) {

		Comment comment = new Comment(request.getText(), request.getCurrent_time(), postId, userId);
		commentrepository.save(comment);
	}
}
