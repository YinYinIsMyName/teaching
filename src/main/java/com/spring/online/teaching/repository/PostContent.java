package com.spring.online.teaching.repository;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.spring.online.teaching.models.User;
import com.spring.online.teaching.models.UserPostContent;
import com.spring.online.teaching.payload.response.ContentResponse;

public interface PostContent extends JpaRepository<com.spring.online.teaching.models.PostContent, Integer> {
//	@Query("select new
//	 com.spring.online.teaching.payload.response.ContentResponse
//	 (p.createId,p.post_id,p.share_content,p.post_option,p.schedule_date,p.schedule_time)
//	 from com.
//	spring.online.teaching.models.PostContent p
//	where p.createId=:createId")

	List<com.spring.online.teaching.models.PostContent> findByCreateId(long createId);

	List<com.spring.online.teaching.models.PostContent> findByPostOption(String option);

	@Query("select new com.spring.online.teaching.payload.response.ContentResponse(pc.createId,pc.post_id,pc.share_content,pc.postOption,pc.scheduleDate,pc.scheduleTime) from com.spring.online.teaching.models.PostContent pc where (pc.scheduleDate<='Jul,15 2020' and pc.scheduleTime<>NOW()) and pc.createId")
	List<ContentResponse> findByTime(@Param("createId") long createId, @Param("date") String date);
}