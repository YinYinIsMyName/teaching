package com.spring.online.teaching.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.spring.online.teaching.models.CreateSection;
import com.spring.online.teaching.models.UserPostContent;

public interface CreateSectionRepository extends JpaRepository<CreateSection, Long> {

	CreateSection findByUniqueKey(String unique_code);
	
}
