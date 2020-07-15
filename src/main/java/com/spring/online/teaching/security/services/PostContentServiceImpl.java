package com.spring.online.teaching.security.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.management.RuntimeErrorException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.online.teaching.models.CreateSection;
import com.spring.online.teaching.models.PostContent;
import com.spring.online.teaching.models.Tag;
import com.spring.online.teaching.models.User;
import com.spring.online.teaching.models.UserPostContent;
import com.spring.online.teaching.payload.request.PostContentRequest;
import com.spring.online.teaching.payload.response.ContentResponse;
import com.spring.online.teaching.repository.CreateSectionRepository;
import com.spring.online.teaching.repository.TagReposistory;
import com.spring.online.teaching.repository.UserRespository;

@Service
public class PostContentServiceImpl {

	@Autowired
	com.spring.online.teaching.repository.PostContent postcontent;
	@Autowired
	UserRespository userrepository;
	@Autowired
	TagReposistory tagreposistory;

	@Transactional
	public void storepost(long createId, long userId, PostContentRequest request) {

		Set<Integer> userIds = request.getTag_id();
		UserPostContent userpostcontent = new UserPostContent();
		PostContent postcontent = new PostContent(request.getContent(), request.getPost_option(),
				request.getSchedule_date(), request.getSchedule_time(), createId, userId);

		if (userIds.size() > 1) {
			for (Integer id : userIds) {

				Tag tagedUser = tagreposistory.findById(id)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				userpostcontent.setTag(tagedUser);
				// userpostcontent.setUniquekey(request.getUnique_code());
				userpostcontent.setPostcontent(postcontent);
				this.postcontent.save(postcontent);
				postcontent.getUserIds().add(userpostcontent);
				this.postcontent.save(postcontent);

			}

		} else {
			Tag tagedUser = tagreposistory.findByIdIn(userIds);
			userpostcontent.setTag(tagedUser);
			// userpostcontent.setUniquekey(request.getUnique_code());
			// we have to set new set postcontnet in object
			userpostcontent.setPostcontent(postcontent);
			postcontent.getUserIds().add(userpostcontent);
			this.postcontent.save(postcontent);

		}

//		postcontent.setUserIds(userLists);

	}

	public List<PostContent> readByCreateId(long createId) {
		List<PostContent> posts = postcontent.findByCreateId(createId);
		return posts;
	}

	public List<PostContent> readByPostOption(String postOption) {
		List<PostContent> postsByOption = postcontent.findByPostOption(postOption);
		return postsByOption;
	}

	

	public List<ContentResponse> readByTime(long createId, String formattedDate) {
		List<ContentResponse> valueByTime = postcontent.findByTime(createId, formattedDate);
		return valueByTime;
	}
}
