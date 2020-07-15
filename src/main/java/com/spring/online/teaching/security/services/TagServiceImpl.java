package com.spring.online.teaching.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.online.teaching.models.Tag;
import com.spring.online.teaching.repository.TagReposistory;

@Service
public class TagServiceImpl {

	@Autowired
	TagReposistory tagReposistory;

	public void writeIntoTagMethod(String username,String uniqueCode) {
		Tag tag = new Tag(username,uniqueCode);
		tagReposistory.save(tag);
	}
}
