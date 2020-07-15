package com.spring.online.teaching.payload.request;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Set;
import javax.validation.constraints.Size;

import com.spring.online.teaching.models.User;

public class PostContentRequest {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM,dd yyyy");
	DateTimeFormatter dtft = DateTimeFormatter.ofPattern("hh:mm a");
	LocalDateTime now = LocalDateTime.now();
	String formattedDate = dtf.format(now);
	String formattedTime = dtft.format(now);
	@Size(min = 1, max = 50)
	private String content = null;
	private String post_option = "post";
	private String schedule_date = formattedDate;
	private String schedule_time = formattedTime;
	private Set<Integer> tag_id;
	//private String unique_code;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPost_option() {
		return post_option;
	}

	public void setPost_option(String post_option) {
		this.post_option = post_option;
	}

	public String getSchedule_date() {
		return schedule_date;
	}

	public void setSchedule_date(String schedule_date) {
		this.schedule_date = schedule_date;
	}

	public String getSchedule_time() {
		return schedule_time;
	}

	public void setSchedule_time(String schedule_time) {
		this.schedule_time = schedule_time;
	}

	public Set<Integer> getTag_id() {
		return tag_id;
	}

	public void setUser_id(Set<Integer> tag_id) {
		this.tag_id = tag_id;
	}

//	public String getUnique_code() {
//		return unique_code;
//	}
//
//	public void setUnique_code(String unique_code) {
//		this.unique_code = unique_code;
//	}

}
