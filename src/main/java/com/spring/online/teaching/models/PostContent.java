package com.spring.online.teaching.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post_content")
public class PostContent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id", unique = true, nullable = false)
	private long post_id;
	@Column(name = "share_content", nullable = true)
	private String share_content;
	@Column(name = "post_option")
	private String post_option;
	@Column(name = "schedule_date")
	private String schedule_date;
	@Column(name = "schedule_time")
	private String schedule_time;
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_post_content", joinColumns = @JoinColumn(name = "post_id"), 
//	inverseJoinColumns = @JoinColumn(name = "user_id"))
	@OneToMany(mappedBy = "postcontent", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserPostContent> userIds = new HashSet<UserPostContent>();

	public PostContent() {
	}

	public PostContent(String share_content, String post_option, String schedule_date, String schedule_time) {
		super();
		this.share_content = share_content;
		this.post_option = post_option;
		this.schedule_date = schedule_date;
		this.schedule_time = schedule_time;
	}

	public long getPost_id() {
		return post_id;
	}

	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}

	public String getShare_content() {
		return share_content;
	}

	public void setShare_content(String share_content) {
		this.share_content = share_content;
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

	public Set<UserPostContent> getUserIds() {
		return userIds;
	}

	public void setUserIds(Set<UserPostContent> userIds) {
		this.userIds = userIds;
	}

	@Override
	public String toString() {
		return "PostContent [share_content=" + share_content + ", post_option=" + post_option + ", schedule_date="
				+ schedule_date + ", schedule_time=" + schedule_time + "]";
	}

}
