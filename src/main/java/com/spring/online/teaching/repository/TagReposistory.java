package com.spring.online.teaching.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.online.teaching.models.Tag;
import com.spring.online.teaching.models.User;

public interface TagReposistory extends JpaRepository<Tag, Integer> {
	Tag findByIdIn(Set<Integer> ids);
}
